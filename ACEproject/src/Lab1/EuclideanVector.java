package Lab1;



/**
 *  The Euclidean Vector class represents a d-dimensional Euclidean vector.
 *  Euclidean vectors are immutable: their values cannot be changed after they are created.
 *  It includes methods for addition, subtraction,
 *  dot product, scalar product, unit vector, Euclidean norm, and the Euclidean
 *  distance between two Euclidean vectors.
 */
public class EuclideanVector { 

	private double[] vector = new double[10];
	
    /**
     * Initializes a d-dimensional zero vector.
     *
     * @param d the dimension of the vector
     */
    public EuclideanVector(int d) {
        vector[0] = (double)d;
        vector[1] = vector[1] = vector[2] = vector[3] = vector[4] = vector[5] = vector[6] = vector[7] = vector[8] = vector[9] = 0.0;
    }

    /**
     * Initializes a vector from an array.
     * 
     * @param a  the array
     */
    public EuclideanVector(double[] a) {
       if (a.length == 4) {
    	   //System.out.println("in second constructure");
    	   this.vector[0] = a.length/2;
    	   System.arraycopy(a, 0, vector, 1, a.length);
       }
            
    }


    /**
     * Returns the dimension of this vector.
     *
     * @return the dimension of this vector
     */
    public int dimension() {
        return (int)vector[0];
    }

    /**
     * Returns the dot product of this vector with the specified vector.
     *
     * @param  vec the other vector
     * @return the dot product of this vector and that vector
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public double dot(EuclideanVector vec) {
    	try {
			if(vec.vector[0] != this.vector[0])
				throw new IllegalArgumentException();
			if(this.vector[0] == 2)
//				System.out.println(this.vector[1]);
//				System.out.println(vec.vector[1]);
//				System.out.println(this.vector[2]);
//				System.out.println(vec.vector[2]);
//				System.out.println(this.vector[3]);
//				System.out.println(vec.vector[3]);
//				System.out.println(this.vector[4]);
//				System.out.println(vec.vector[4]);
				return (this.vector[1]*vec.vector[1])+(this.vector[2]*vec.vector[2])+(this.vector[3]*vec.vector[3])+(this.vector[4]*vec.vector[4]);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
    	
        return -1;
    }

    /**
     * Returns the magnitude of this vector.
     * This is also known as the L2 norm or the Euclidean norm.
     *
     * @return the magnitude of this vector
     */
    public double magnitude() {
//    	if (vector[0] == 2)
        	return Math.sqrt(Math.pow(vector[1], 2)+Math.pow(vector[2], 2)+Math.pow(vector[3], 2)+Math.pow(vector[4], 2));
    }

    /**
     * Returns the Euclidean distance between this vector and the specified vector.
     *
     * @param  vec the other vector 
     * @return the Euclidean distance between this vector and that vector
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public double distanceTo(EuclideanVector vec) {
    	try {
			if(vec.vector[0] != this.vector[0])
				throw new IllegalArgumentException();
			if(vec.vector[0] == 2)
				return Math.sqrt(
						Math.pow((vec.vector[1]-this.vector[1]),2)+
						Math.pow((vec.vector[2]-this.vector[2]),2)+
						Math.pow((vec.vector[3]-this.vector[3]),2)+
						Math.pow((vec.vector[4]-this.vector[4]),2)
						);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
		}
        return -1;
    }

    /**
     * Returns the sum of this vector and the specified vector.
     *
     * @param  vec the vector to add to this vector
     * @return the vector whose value is (this + vec)
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public EuclideanVector plus(EuclideanVector vec) {
    	EuclideanVector tem = new EuclideanVector((int)vec.vector.length/2);
    	tem.vector[1] = this.vector[1] + vec.vector[1];
    	tem.vector[2] = this.vector[2] + vec.vector[2];
    	tem.vector[3] = this.vector[3] + vec.vector[3];
    	tem.vector[4] = this.vector[4] + vec.vector[4];
    	return tem;
    }

    /**
     * Returns the difference between this vector and the specified vector.
     *
     * @param  vec the vector to subtract from this vector
     * @return the vector whose value is (this - vec)
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public EuclideanVector minus(EuclideanVector vec) {
    	EuclideanVector tem = new EuclideanVector((int)vec.vector.length/2);
    	tem.vector[1] = this.vector[1] - vec.vector[1];
    	tem.vector[2] = this.vector[2] - vec.vector[2];
    	tem.vector[3] = this.vector[3] - vec.vector[3];
    	tem.vector[4] = this.vector[4] - vec.vector[4];       
    	return tem;
    }

    /**
     * Returns the ith cartesian coordinate.
     *
     * @param  i the coordinate index
     * @return the ith cartesian coordinate
     */
    public double cartesian(int i) {
    	
    	return this.vector[i];
    }

   

    /**
     * Returns the scalar-vector product of this vector and the specified scalar
     *
     * @param  alpha the scalar
     * @return the vector whose value is (alpha * this)
     */
    public EuclideanVector scale(double alpha) {
    	EuclideanVector tem = new EuclideanVector((int)this.vector.length/2);

    	tem.vector[1] = this.vector[1]*alpha;
    	tem.vector[2] = this.vector[2]*alpha;
    	tem.vector[3] = this.vector[3]*alpha;
    	tem.vector[4] = this.vector[4]*alpha;
    	
    	return tem;
    }

    /**
     * Returns a unit vector in the direction of this vector.
     *
     * @return a unit vector in the direction of this vector
     * @throws ArithmeticException if this vector is the zero vector
     */
    public EuclideanVector direction() {
    	EuclideanVector tem = new EuclideanVector((int)this.vector.length/2);
    	tem.vector[1] = this.vector[1]/magnitude();
    	tem.vector[2] = this.vector[2]/magnitude();
    	tem.vector[3] = this.vector[3]/magnitude();
    	tem.vector[4] = this.vector[4]/magnitude();
    	return tem;
    }


    /**
     * Returns a string representation of this vector.
     *
     * @return a string representation of this vector, which consists of the 
     *         the vector entries, separates by single spaces
     */
    public String toString() {
        return this.vector[1]+" "+this.vector[2]+" "+this.vector[3]+" "+this.vector[4];
    }

    /**
     * Unit tests the Vector data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };
        EuclideanVector x = new EuclideanVector(xdata);
        EuclideanVector y = new EuclideanVector(ydata);

        StdOut.println("   x       = " + x);
        StdOut.println("   y       = " + y);

        EuclideanVector z = x.plus(y);
        StdOut.println("   z       = " + z);

        z = z.scale(10.0);
        StdOut.println(" 10z       = " + z);

        StdOut.println("  |x|      = " + x.magnitude());
        StdOut.println(" <x, y>    = " + x.dot(y));
        StdOut.println("dist(x, y) = " + x.distanceTo(y));
        StdOut.println("dir(x)     = " + x.direction());

    }
}

