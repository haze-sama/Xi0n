#include "./Sensor.h"

using namespace std;


Sensor::Sensor(int init_InfraRedSensor_Pin, int init_echo_Pin, int init_trigger_Pin) {
	//Serial.println ("CREATE SENSOR");
	infraRedSensor = new InfraRedSensor(init_InfraRedSensor_Pin);
	ultrason = new Ultrason(init_echo_Pin, init_trigger_Pin);
}

Sensor::~Sensor() {
	//Serial.println ("DELETE SENSOR");
	delete infraRedSensor;
	delete ultrason;
}

float Sensor::getDistanceUltrasion() {
	float value = ultrason->getDistance();
	
	if (value > 255)
		return 255;

	return value;
}

float Sensor::getDistanceInfraRedSensor() {

	return infraRedSensor->getDistance();
}