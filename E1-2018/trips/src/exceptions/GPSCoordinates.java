package src.exceptions;

public class GPSCoordinates {
	
	private double lat; // in degrees
	private double lon; // in degrees
	private double alt; // in meters

	public GPSCoordinates(double lat, double lon, double alt) {
		if(lat<-90 || lat>90){
			String anomaly = "Latitude must be between -90º and 90º and is "+ lat;
			throw new IllegalArgumentException(anomaly);
		}
		if(lon<-180|| lon>180){
			String anomaly = "Longitude must be between -180º and 180º and is "+ lon;
			throw new IllegalArgumentException(anomaly);
		}
		if(alt<-430 || alt>8848){
			String anomaly = "Altitude must be between -430m and 8848m and is "+ lat;
			throw new IllegalArgumentException(anomaly);
		}
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}
	
	@Override
	public String toString() {
		return String.format("%11.6f deg %11.6f deg %4.0f m", lat, lon, alt);
	}
}
