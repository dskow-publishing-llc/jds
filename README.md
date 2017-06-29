# jds - JournalDoc Downloader System

This system provides a web ui to enter search queries and get results from mongo.  It has a controller to run the search and fetch actions while following the Extrez guidelines. The results are uploaded into mongo collections.

The system contains:
* Entrez swagger client 
* Swagger spring boot app service 
* Mongodb client
* Dockerfile for deployment

The Entrez swagger client implements part of the entrex api.  See [Entrez Programming Utilities Help](https://www.ncbi.nlm.nih.gov/books/NBK25497/)

The Entrez api can be used between 9 PM and 5 AM Eastern.  See [Eztrez usage guidelines](https://www.ncbi.nlm.nih.gov/books/NBK25497/#chapter2.Usage_Guidelines_and_Requiremen)

Here is an example of starting the service from command line while setting the mongo location.

    java -Dmonhost=localhost -monport=27017 -Dmondb=jds -jar downloader-server-1.0.jar

Here is an example of starting the docker container.

    docker run -p8080:8080 dskow/jds:1.0
