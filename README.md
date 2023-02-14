# day27

## Setting up mongo

1. In the netwoek access, ip address set to below to access from anywhere
```
0.0.0.0/0
```
2. Use the following command found in Database -> Connect button to connect to db
```
set MONGO_URL=mongodb+srv://cluster0.v9bscsj.mongodb.net/myFirstDatabase
```
3.
```
set USERNAME=tester
set PASSWORD=password12345
```
4.
```
mongoimport %MONGO_URL% --username %USERNAME% --password %PASSWORD% \ -d bgg -c game --jsonArray --file ./game.json --drop
```
```
mongoimport %MONGO_URL% --username %USERNAME% -d bgg -c comment --jsonArray --file ./comment.json --drop
```
5. SQL command
* Under the same directory
```
mysqlsh
source bgg.sql;
mysql -uroot -p;
grant all on privileges on bgg.* to 'tester'@'%';
flush privileges;
exit
```
reconnect using the old
6. Mongo queries learnt
```
mongo query
db.tv.find({
    language: "English"
})
    
db.tv.find({
  language: "English",
  status: "Ended"
})

db.tv.find({
  language: {
    $regex: 'english',
    $options: 'i'
  }
})
db.tv.find({
  name: {
    $regex: 'kill',
    $options: 'i'
  }
})
db.tv.find({
  genres: {
    $in: ['Crime']
  },
  "rating.average": {
    $gte: 7
  }
})

db.tv.distinct("type")

db.tv.find().count()

db.tv.find({
    type: {$regex: 'Animation', $options: 'i'}
})
.sort({"rating.average": -1})
.projection({_id:0,id:1,name:1,rating.average:1})

db.friends.insert({name: 'fred',email:'fred@gmaill.com'})

db.friends.find({_id:'barney@gmail.com'})
```
