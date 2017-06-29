#!/bin/bash
set -e

if [ ! -f "$JDS_BASE/shiro.ini" ] ; then
  # First time
  echo "###################################"
  echo "Initializing JournalDoc JDS"
  echo ""
  cp "$JDS_HOME/shiro.ini" "$JDS_BASE/shiro.ini"
  if [ -z "$ADMIN_PASSWORD" ] ; then
    ADMIN_PASSWORD=$(pwgen -s 15)
    echo "Randomly generated admin password:"
    echo ""
    echo "admin=$ADMIN_PASSWORD"
  fi
  echo ""
  echo "###################################"
fi

# $ADMIN_PASSWORD can always override
if [ -n "$ADMIN_PASSWORD" ] ; then
  sed -i "s/^admin=.*/admin=$ADMIN_PASSWORD/" "$JDS_BASE/shiro.ini"
fi

exec "$@"