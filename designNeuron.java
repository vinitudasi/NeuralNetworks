/**
 * Name: Vinit Udasi
 * Student:6847800
 * SUBJECT: COSC 3P71 FALL 2021
 * Instructor: Dr. Ombuki-Berman
 * Email:vu19pt@brocku.ca
 */


public interface designNeuron {
    public float getError();
    public void setSample(float[] input);
    public float[] getSample();
    public void setError(float MSE);
    public void setTargetOutput(float[] givenOutput);
    public float[] getTargetOutput();
}
