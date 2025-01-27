SELECT
    Id
FROM
    Weather AS W1
WHERE
    Temperature > (
        SELECT
            Temperature
        FROM
            Weather AS W2
        WHERE
            W2.RecordDate = DATE_ADD(W1.RecordDate, INTERVAL -1 DAY)
    );
