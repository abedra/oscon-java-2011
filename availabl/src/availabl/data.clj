(ns availabl.data)

(def hosts [{:hostname "foo"
              :uptime {:up "34 min" :users 2 :load-average "0.10, 0.11, 0.17"}
             :updates-available 0}
            {:hostname "bar"
             :uptime {:up "57 days 20 min" :users 7 :load-average "1.10, 3.11, 2.17"}
             :updates-available 8}
            {:hostname "baaz"
             :uptime {:up "127 days 2 min" :users 10 :load-average " 0.06, 1.21, 1.42"}
             :updates-available 3}])