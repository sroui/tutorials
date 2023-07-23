# Order service
Order service is a demo microservice that demonstrates how to implement observability and monitoring in Spring 
applications. The order service handles all the business logic related to orders.

The responsibilities of the order service are:

- Client can place an order
- Client can cancel an order 
- Client can track an order

# Observables

The observables exposed by the order service are listed bellow:

## Metrics:
- `orders`: counter
- `orders.size`: Gauge - has a category label
- Observation api metrics:
  - `orders.processing.time`: Histogram & Summary

## Traces:

## Logs:



## BACKLOG
- DONE what types of metrics you can use with the observation api
  - the observation api supports only Timer and Sample API which are part of Gauge
  Histogram, and Summary
- Add documentation
- Add docker compose file and set ggrafana, tracing technology, prometheus
- Add code documentation
- Add unit/integration tests
- Add observation code
- Add tracing code
- Set up grafana dashboards