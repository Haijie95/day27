0.0.0.0/0
access from anywher ip

set MONGO_URL=mongodb+srv://cluster0.v9bscsj.mongodb.net/myFirstDatabase

set USERNAME=tester
set PASSWORD=password12345

mongoimport %MONGO_URL% --username %USERNAME% --password %PASSWORD% \ -d bgg -c game --jsonArray --file ./game.json --drop

mongoimport %MONGO_URL% --username %USERNAME% -d bgg -c comment --jsonArray --file ./comment.json --drop

in the same directory
mysqlsh
source bgg.sql;
mysql -uroot -p;
grant all on privileges on bgg.* to 'tester'@'%';
flush privileges;
exit
reconnect using the old