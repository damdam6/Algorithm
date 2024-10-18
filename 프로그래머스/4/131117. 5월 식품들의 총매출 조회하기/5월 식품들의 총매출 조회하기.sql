-- FOOD_PRODUCT P
-- FOOD_ORDER O

-- 조회 
-- 식품 ID, 식품 이름, 총매출

-- 조건
-- 생산일자가 2022년 5월인 식품
-- 총매출을 기준으로 내림차순 정렬 / 식품 ID를 기준으로 오름차순 정렬

SELECT
    P.PRODUCT_ID,
    P.PRODUCT_NAME,
    SUM(P.PRICE * O.AMOUNT) AS TOTAL_SALES

FROM
    FOOD_PRODUCT P
    JOIN
        (
            SELECT
                PRODUCT_ID,
                AMOUNT
            FROM
                FOOD_ORDER
            WHERE
                MONTH(PRODUCE_DATE) = 5
                AND
                YEAR(PRODUCE_DATE) = 2022
        ) O
    ON
        P.PRODUCT_ID = O.PRODUCT_ID
GROUP BY
    P.PRODUCT_ID
ORDER BY
    TOTAL_SALES DESC,
    PRODUCT_ID ASC