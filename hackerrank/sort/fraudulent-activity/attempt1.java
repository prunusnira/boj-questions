// 시간초과

// Complete the activityNotifications function below.
static int activityNotifications(int[] expenditure, int d) {
    int[] arr = new int[d];
    int count = 0;
    int idx = d;
    int mid = 0;
    int inneridx = 0;

    // 중간값 위치
    int center = d / 2;
    boolean isEven = d % 2 == 0 ? true : false;

    for(int i = 0; i < d; i++) {
        arr[i] = expenditure[i];
    }

    while(idx < expenditure.length) {
        int[] clone = arr.clone();
        Arrays.sort(clone);

        int nextval = expenditure[idx];
        int medval = isEven ?
                (clone[center] + clone[center+1]) / 2
                :
                clone[center];

        if(nextval >= 2 * medval) count++;

        // Next turn check
        arr[inneridx] = nextval;
        idx++;
        inneridx++;
        if(inneridx == d) inneridx = 0;
    }

    return count;
}