import java.util.Scanner;

class Matrix {
    int row, column;
    float mat[][];

    public Matrix() {
        this.row = 2;
        this.column = 2;
        this.mat = new float[row][column];
    }

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        this.mat = new float[row][column];
    }

    public void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter elements for a " + row + "x" + column + " matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Enter element at position (" + (i + 1) + "," + (j + 1) + "): ");
                mat[i][j] = scanner.nextFloat();
            }
        }
    }

    public float[][] transpose() {
        float[][] transposed = new float[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                transposed[j][i] = mat[i][j];
            }
        }
        return transposed;
    }

    public float[][] matrixMultiplication(Matrix second) {
        if (this.column != second.row) {
            throw new IllegalArgumentException("Matrix multiplication is not possible");
        }

        float[][] result = new float[this.row][second.column];
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < second.column; j++) {
                for (int k = 0; k < this.column; k++) {
                    result[i][j] += this.mat[i][k] * second.mat[k][j];
                }
            }
        }
        return result;
    }

    public void displayMatrix(float[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void displayMatrix() {
        displayMatrix(this.mat);
    }

    public float maximum_of_array() {
        float max = mat[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }
            }
        }
        return max;
    }

    public float average_of_array() {
        float sum = 0;
        int totalElements = row * column;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum += mat[i][j];
            }
        }
        return sum / totalElements;
    }

    public static void main(String[] args) {
        Matrix matrix1 = new Matrix();
        matrix1.readMatrix();
        System.out.println("\nMatrix 1:");
        matrix1.displayMatrix();

        Matrix matrix3 = new Matrix(2, 2);
        matrix3.readMatrix();
        System.out.println("\nMatrix 3:");
        matrix3.displayMatrix();

        System.out.println("\nTranspose of Matrix 1:");
        float[][] transposed = matrix1.transpose();
        matrix1.displayMatrix(transposed);

        System.out.println("\nMultiplication of Matrix 1 and Matrix 3:");
        float[][] product = matrix1.matrixMultiplication(matrix3);
        matrix1.displayMatrix(product);

        System.out.println("\nMaximum value in Matrix 1: " + matrix1.maximum_of_array());
        System.out.println("Average value in Matrix 1: " + matrix1.average_of_array());
    }
}
