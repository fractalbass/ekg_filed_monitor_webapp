package com.paintedharmony.ekgfm.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by milesporter on 4/25/16.
 */
public class SampleSetTest {

    @Test
    public void testBulkSampleSet() {
        SampleSet sSet = genSampleSet(100);
        Assert.assertTrue(sSet.samples.size()==100);
    }

    @Test
    public void testSampleSet() {
        Sample s1 = new Sample(3,2,3);
        Sample s2 = new Sample(2,5,6);
        Sample s3 = new Sample(1,7,8);
        ArrayList<Sample> sArray = new ArrayList<>();
        sArray.add(s1);
        sArray.add(s2);
        sArray.add(s3);
        SampleSet sSet = new SampleSet(sArray);
        Assert.assertEquals(sSet.getSize(), 3);
        Assert.assertEquals(sSet.getMaxSampleValue(), 7);
        Assert.assertEquals(sSet.getMinSampleValue(), 2);
        SampleSet orderedSamples = sSet.getOrderedSampleSet();
        Assert.assertTrue(orderedSamples.getSample(0).equals(s1));
        Assert.assertTrue(orderedSamples.getSample(1).equals(s2));
        Assert.assertTrue(orderedSamples.getSample(2).equals(s3));

    }

    private SampleSet genSampleSet(int samples) {
        SampleSet sSet = new SampleSet();
        for (int i=0;i<samples;i++) {
            Sample s = new Sample(i,
                                    (int)(Math.random()*250),
                    (int) (17+(Math.random()*5)));
            sSet.samples.add(s);
        }
        return sSet;
    }
}
