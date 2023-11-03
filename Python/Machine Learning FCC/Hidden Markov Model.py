import tensorflow_probability as tfp
import tensorflow as tf

tfd = tfp.distributions
initial_distribution = tfd.Categorical(probs=[0.8, 0.2]) # Intial distribution is 80%, 20%
transition_distribution = tfd.Categorical(probs=[[0.7, 0.3], # Probabilites of a transition occuring
                                          [0.2, 0.8]])
observation_distribution = tfd.Normal(loc=[0., 15.], scale=[5., 10.]) # loc = mean and scale = standard deviation


model = tfd.HiddenMarkovModel(
    initial_distribution=initial_distribution,
    transition_distribution=transition_distribution,
    observation_distribution = observation_distribution,
    num_steps=7)

mean = model.mean() # Calculates probability from the model

with tf.compat.v1.Session() as sess:
    print(mean.numpy()) # Prints expected temperatures for each day