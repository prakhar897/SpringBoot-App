To run elastic search:
cd /usr/local/Cellar/elasticsearch-full/7.6.1 OR the place where you installed elastic search
./bin/elasticsearch

To run redis:
redis-server

Run flask api:
python3 app.py

To kill redis server:
ps -ef |grep redis
kill -9 "server id"