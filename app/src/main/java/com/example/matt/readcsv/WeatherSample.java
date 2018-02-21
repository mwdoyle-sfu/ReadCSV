package com.example.matt.readcsv;

class WeatherSample {

    private String month;
    private double rainfall;
    private int sunhours;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getRainfall() {
        return rainfall;
    }

    public void setRainfall(double rainfall) {
        this.rainfall = rainfall;
    }

    public int getSunhours() {
        return sunhours;
    }

    public void setSunhours(int sunhours) {
        this.sunhours = sunhours;
    }

    @Override
    public String toString() {
        return "WeatherSample{" +
                "month='" + month + '\'' +
                ", rainfall=" + rainfall +
                ", sunhours=" + sunhours +
                '}';
    }
}
