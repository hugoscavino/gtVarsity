import java.util.InputMismatchException;
import java.util.Scanner;

public class PointList {

    //data member
    double[][] points;

    public PointList(int numPoints) {
        points = new double[numPoints][2];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numPoints; i++) {
            System.out.println("Enter the coordinates of the [" + i +"] point:");
            System.out.println("Enter the x value: ");
            points[i][0] = scanner.nextDouble();
            System.out.println("Enter the y value: ");
            points[i][1] = scanner.nextDouble();
        }

        // Display menu options
        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Find centroid");
            System.out.println("2. Find farthest pair of points");
            System.out.println("3. Find closest pair of points");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        findCentroid(points);
                        break;
                    case 2:
                        findFarthestPair(points);
                        break;
                    case 3:
                        findClosestPair(points);
                        break;
                    case 4:
                        System.out.println("Exiting program.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid choice. Please try again.");
            }

        }

    }

    /**
     * <a href="https://www.omnicalculator.com/math/centroid">...</a>
     * @param points Coordinates
     */
    public void findCentroid(double[][] points) {
        double sumX = 0;
        double sumY = 0;
        int n = points.length;

        for (double[] point : points) {
            sumX += point[0];
            sumY += point[1];
        }

        double centroidX = sumX / n;
        double centroidY = sumY / n;
        System.out.println("Centroid of the points: (" + centroidX + ", " + centroidY + ")");
    }

    // Find and display the farthest pair of points
    public void findFarthestPair(double[][] points) {
        double maxDistance = 0;
        double[] point1 = new double[2];
        double[] point2 = new double[2];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = calculateDistance(points[i], points[j]);
                if (distance > maxDistance) {
                    maxDistance = distance;
                    point1 = points[i];
                    point2 = points[j];
                }
            }
        }

        System.out.println("Farthest points: (" + point1[0] + ", " + point1[1] + ") " +
                "and (" + point2[0] + ", " + point2[1] + ")");
        System.out.println("Distance: " + maxDistance);
    }

    // Find and display the closest pair of points
    public void findClosestPair(double[][] points) {
        double minDistance = Double.MAX_VALUE;
        double[] point1 = new double[2], point2 = new double[2];

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = calculateDistance(points[i], points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    point1 = points[i];
                    point2 = points[j];
                }
            }
        }

        System.out.println("Closest points: (" + point1[0] + ", " + point1[1] + ") " +
                "and (" + point2[0] + ", " + point2[1] + ")");
        System.out.println("Distance: " + minDistance);
    }

    /**
     * Helper method to calculate distance between two points
     * (p1[0] - p2[0]) squared + (p1[0] - p2[0]) then the square root
     * @param point1 Point One
     * @param point2 Point Two
     * @return distance between two points
     */
    public double calculateDistance(double[] point1, double[] point2) {
        double dist =   Math.pow(point1[0] - point2[0], 2) +
                        Math.pow(point1[1] - point2[1], 2);
        return Math.sqrt(dist);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many points they want to enter
        System.out.print("Enter the number of points: ");
        int numPoints = scanner.nextInt();
        PointList pl = new PointList(numPoints);
    }







}

