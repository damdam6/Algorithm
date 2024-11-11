function solution(n, works) {
    // 작업량이 없으면 야근 지수는 0입니다.
    if (works.reduce((a, b) => a + b, 0) <= n) {
        return 0;
    }

    // 작업량을 내림차순으로 정렬합니다.
    works.sort((a, b) => b - a);

    while (n > 0) {
        // 가장 큰 작업량을 줄입니다.
        works[0] -= 1;
        n--;

        // 작업량을 재정렬하여 가장 큰 값이 앞에 오도록 합니다.
        let i = 0;
        // 다음 작업량과 비교하여 현재 작업량이 더 작으면 자리 교환
        while (i < works.length - 1 && works[i] < works[i + 1]) {
            [works[i], works[i + 1]] = [works[i + 1], works[i]];
            i++;
        }
    }

    // 남은 작업량의 제곱합을 계산합니다.
    return works.reduce((sum, work) => sum + Math.pow(work, 2), 0);
}
