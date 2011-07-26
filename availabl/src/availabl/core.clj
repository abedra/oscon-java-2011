(ns availabl.core
  (:use [clojure.tools.logging :only (debug info)]
        [ring.adapter.jetty :only (run-jetty)]
        [ring.middleware.params :only (wrap-params)]
        [ring.middleware.keyword-params :only (wrap-keyword-params)]
        [compojure.core :only (defroutes GET)])
  (:require [clojure.data.json :as json]
            [compojure.route :as route]
            [compojure.handler :as handler]
            [availabl.data :as data])
  (:gen-class))

(defn wrap-logging [app]
  (fn [req]
    (info (str (.toUpperCase (name (:request-method req))) " " (:uri req)
               " " (:params req)))
    (app req)))

(defn lookup [params]
  (let [hostname (:hostname params)]
    (info (str "Looking up host " hostname))
    (if-let [hostinfo (first (filter #(= (:hostname %) hostname) data/hosts))]
      (do (info (str "Returning host with data " hostinfo))
          (json/json-str hostinfo))
      (do
        (info "Could not locate host " hostname)
        {:status 404 :body "Not Found\n"}))))

(defroutes routes
  (GET "/" {params :params} (lookup params))
  (route/not-found "Not Found"))

(def application
  (-> routes
      wrap-logging
      wrap-keyword-params
      wrap-params))

(defn -main []
  (run-jetty (var application) {:port 8080
                                :join? false}))
