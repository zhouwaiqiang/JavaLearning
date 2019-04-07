package com.springinaction.springidol;

import java.util.Collection;

/**
 * Created by 强 on 2018/12/13.
 */
public class OneManBand implements Performer {
    private Collection<Instrument> instruments;

    private void setInstruments(Collection<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public void perform() {
        for (Instrument instrument : instruments) {
            instrument.play();
        }
    }
}
