package meteo;

public class MeteoSample {
	private double temperature;
	private double pressure;
	private double humidity;

	public MeteoSample(double t, double p, double h) {
		if(t<-273.15 || t>60){
			String anomaly = "Temperature must be in [-273.15,60] and is " + t;
			throw new IllegalArgumentException(anomaly);
		}
		if(p<870 || p>1086.8){
			String anomaly = "Pressure must be in [870,1086.8] and is " + p;
			throw new IllegalArgumentException(anomaly);
		}
		if(h<0 || h>100){
			String anomaly = "Humidity must be in [0,100] and is " + h;
			throw new IllegalArgumentException(anomaly);
		}
		this.humidity = h;
		this.pressure = p;
		this.temperature = t;
	}

	public String toString(){
		return this.temperature + "ºC, " + this.pressure + " hPa, " + this.humidity + "% humidity";
	}
	
}
