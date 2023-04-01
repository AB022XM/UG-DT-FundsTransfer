#!/usr/bin/env bash

function log {
    echo "[$(date)]: $*"
}

log "Start Redis Cluster builder"
sleep 5

log "Connect all Redis containers"
redis-cli \
    --cluster-replicas 1 \
    --cluster-yes \
    --cluster create \
        $(host fundstransferapigeneric-redis|awk '{print $4}'):6379 \
        $(host fundstransferapigeneric-redis-1|awk '{print $4}'):6379 \
        $(host fundstransferapigeneric-redis-2|awk '{print $4}'):6379 \
        $(host fundstransferapigeneric-redis-3|awk '{print $4}'):6379 \
        $(host fundstransferapigeneric-redis-4|awk '{print $4}'):6379 \
        $(host fundstransferapigeneric-redis-5|awk '{print $4}'):6379
