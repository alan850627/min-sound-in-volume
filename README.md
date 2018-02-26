# Attempt to use genetic algorithm to minimize sound at a volume

Given a noise source, and an initial speaker location, we randomly generate same frequency noise at some phase and amplitude.
We then mutate the amplitude and the phase and calculate the average perceived sound at a given volume. 
We keep the mutations that are doing better than before, throw away the bad performing ones and continue to mutate.

# 7 speaker
1611
-----
Room:  
* Signal 0: 1.0exp(j*0.0) at (20.0, 0.0, 0.0) at 440.0Hz  
* Signal 1: 1.6476662257901702exp(j*4.827852305322381) at (0.0, 3.0, 0.0) at 440.0Hz  
* Signal 2: 1.8596980520463882exp(j*6.719865988909773) at (0.0, 2.0, 0.0) at 440.0Hz  
* Signal 3: 3.1129330577409022exp(j*1.7393134447001524) at (0.0, 1.0, 0.0) at 440.0Hz  
* Signal 4: 1.3601634502270443exp(j*5.562485247766654) at (0.0, 0.0, 0.0) at 440.0Hz  
* Signal 5: 1.126359389941583exp(j*2.5108468116522125) at (0.0, -1.0, 0.0) at 440.0Hz  
* Signal 6: 2.154907138560062exp(j*4.739051853204575) at (0.0, -2.0, 0.0) at 440.0Hz  
* Signal 7: 3.3789067448677677exp(j*4.869365530875367) at (0.0, -3.0, 0.0) at 440.0Hz  

Avg: 0.022848829113877884  
Original dB: 70.45757490560675dB  
New dB: 61.15667907863574dB  
-----
