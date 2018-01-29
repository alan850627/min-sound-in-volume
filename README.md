# Attempt to use genetic algorithm to minimize sound at a volume

Given a noise source, and an initial speaker location, we randomly generate same frequency noise at some phase and amplitude.
We then mutate the amplitude and the phase and calculate the average perceived sound at a given volume. 
We keep the mutations that are doing better than before, throw away the bad performing ones and continue to mutate.
