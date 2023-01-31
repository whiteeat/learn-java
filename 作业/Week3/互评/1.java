class Main {
    public static void main(String[] args) {

        int[] num = new int[99];

        boolean[] isAlive = new boolean[99];

        int temp = 2;

        for (int i = 0; i <= 98; i++) {

            num[i] = i + 2;

            isAlive[i] = true;

        }

        while (temp * temp < 100) {

            for (int n : num) {

                if (n % temp == 0 && n != temp)

                    isAlive[n - 2] = false;

            }

            for (int n : num) {

                if (n > temp && isAlive[n - 2]) {

                    temp = n;

                    break;

                }

            }

        }

        for (int n : num) {

            if (isAlive[n - 2])

                System.out.print(n + " ");

        }

    }

 }