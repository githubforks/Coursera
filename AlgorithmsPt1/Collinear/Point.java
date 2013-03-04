/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();       // YOUR DEFINITION HERE

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
 
    
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        double xdiff = (double) (that.x - this.x);
        double ydiff = (double) (that.y - this.y);
        
        if (xdiff == 0 && ydiff == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (xdiff == 0) {
            return Double.POSITIVE_INFINITY;
        }
        if (ydiff == 0) {
            return 0.0;
        }

        else {
            double slope =  ydiff /  xdiff;
            return slope;
        }
        
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (that.y < this.y) {
            return 1;
        }
        else if (that.y > this.y) {
            return -1;
        }
        else {
            if (this.x > that.x){
                return 1;
            }
            else if (this.x < that.x){
                return -1;
            }
            else {
                return 0;
            }
        }
        
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }
    
    private class SlopeOrder implements Comparator<Point> {
        public int compare(Point p1, Point p2) {
            double a = Point.this.slopeTo(p1);
            double b = Point.this.slopeTo(p2);
            int diff = (int) (a-b);
            if (a < b) {
                return -1;
            }
            else if (a == b) {
                return 0;
            }
            else 
                return 1;
        }
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        Point p1 = new Point(10000,0);
        Point p2 = new Point (0,10000);
        Point p3 = new Point(3000,7000);
        Point p4 = new Point(7000,3000);
        Point p5 = new Point(20000,21000);
        Point p6 = new Point(3000,4000);
        Point p7 = new Point(14000,15000);
        Point p8 = new Point(6000,7000);;
        System.out.println(p6.slopeTo(p8));
        System.out.println(p6.slopeTo(p7));
        System.out.println(p6.slopeTo(p5));

    }
}
