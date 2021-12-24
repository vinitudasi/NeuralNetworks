/**
 * Name: Vinit Udasi
 * Student:6847800
 * SUBJECT: COSC 3P71 FALL 2021
 * Instructor: Dr. Ombuki-Berman
 * Email:vu19pt@brocku.ca
 */
public interface NetworkDesign {
    public void train(float[] input, float[] expectedOutput, float learningRate,int iter);
    public float[] feedforward(float[] givenInput);
    public void backpropagation(float[] targetOutput);
    public void updateWeights(float alpha);
}
/**
 * A simple feedforward neural network has 3 basic functions
 * feedforward to move forward in the Network
 * Backpropogation (for this assignment)
 * Updating the weights after each epoch
 * And one function that calls these 3 functions (driver) :- train
 * */