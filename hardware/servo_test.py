import RPi.GPIO as GPIO
import time

GPIO.setmode(GPIO.BOARD)

GPIO.setup(18,GPIO.OUT)

try:
    while True:
        GPIO.output(18,1)
        time.sleep(0.0015)
        GPIO.output(18,0)

        time.sleep(2)
except KeyboardInterrupt:
    GPIO.cleanup()
