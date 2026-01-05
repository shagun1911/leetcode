SELECT today.id
FROM Weather today
JOIN Weather yesterday
  ON yesterday.recordDate = DATE_SUB(today.recordDate, INTERVAL 1 DAY)
WHERE today.temperature > yesterday.temperature;
