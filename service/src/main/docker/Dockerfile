FROM alpine:3.5
RUN apk add --update openjdk8-jre pwgen bash curl && rm -rf /var/cache/apk/*

MAINTAINER David Skowronski <david@dskow.com>, https://dskow.com/downloader/jds-server.git

# Config and data
ENV JDS_BASE /journaldoc-downloader
ENV JDS_PORT 8080

# Installation folder
ENV JDS_HOME /journaldoc-downloader

WORKDIR /tmp
	

# As "localhost" is often inaccessible within Docker container,
# we'll enable basic-auth with a random admin password
# (which we'll generate on start-up)
COPY downloader-server-2.5-SNAPSHOT.jar /journaldoc-downloader/jds-server.jar
COPY jds-server /journaldoc-downloader/jds-server
COPY shiro.ini /journaldoc-downloader/shiro.ini
COPY docker-entrypoint.sh /
RUN chmod 755 /docker-entrypoint.sh

# Where we start our server from
WORKDIR /journaldoc-downloader
EXPOSE 8080
# use this for just jds.
ENTRYPOINT ["/docker-entrypoint.sh"]
CMD ["/journaldoc-downloader/jds-server"]
