/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.datatorrent.testapp;

import com.datatorrent.api.DefaultInputPort;
import com.datatorrent.common.util.BaseOperator;

public class TupleReciever extends BaseOperator
{
  private boolean dumpedStack = false;

  public final transient DefaultInputPort<Double> input = new DefaultInputPort<Double>() {
    @Override
    public void process(Double t)
    {
      if(!dumpedStack) {
        Thread.dumpStack();
        dumpedStack = true;
      }
    }
  };
}
