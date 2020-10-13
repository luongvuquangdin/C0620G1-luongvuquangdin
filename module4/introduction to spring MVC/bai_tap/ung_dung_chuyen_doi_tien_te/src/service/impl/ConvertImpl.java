package service.impl;

import org.springframework.stereotype.Service;
import service.Convert;

@Service
public class ConvertImpl implements Convert {
    private static final double EXCHANGE_RATE=23000;
    @Override
    public double ConvertUSD(double vietNam) {
        return vietNam/EXCHANGE_RATE;
    }

    @Override
    public double ConvertVietNam(double usa) {
        return usa*EXCHANGE_RATE;
    }
}
