library(tidyverse)

# Using Star Wars dataset
# Calling dataset and then a pipe operator (Ctrl + Shift + M)
#  %>% brings information to the next line of code
starwars %>%
    filter(height > 150 & mass < 200) %>% # Filters dataset for x and y parameters
    mutate(height_in_meters = height/100) %>%  # Creates a new var/overwrites an existing var
    select(height_in_meters, mass) %>% # Tells what variables are being worked with and included in output
    arrange(mass) %>% # Sorts by ascending values, but adding a negative to mass makes it descending
     # View() Shows the dataframe
     plot() # Plots mass against height_in_meters

# Exploring the dataset:
# msleep dataset about mammals and their sleeping habits
View(msleep)
glimpse(msleep) # shows quick overview of data
head(msleep) # gives first six rows, with some of the var
class(msleep$name) # tells you class of a var, '$' refers to what var is being looked at.
length(msleep) # gives number of var
length(msleep$name) # tells how many observations in a specific var
names(msleep) # gives all names of var
unique(msleep$vore) # tells all the unique categories in a var

missing <- !complete.cases(msleep) # tells you rows of data that aren't missing info, '!' runs the opposite operation
msleep[missing, ] # Shows all rows with missing data

# Cleaning data:
# Using Star Wars dataset
starwars %>% 
    select(name, height, mass) # or 'select(1:3)' works
starwars %>% 
    select(ends_with("color")) %>% # all var names that end with color
    View()
starwars %>% 
    rename("characters" = "name") %>% # changes var name (from 'name' to 'characters')
    head()

class(starwars$hair_color)
starwars$haircolor <- as.factor(starwars$hair_color) # overwrites class as factor class
class(starwars$hair_color)

starwars %>% 
    mutate(hair_color = as.character(hair_color)) %>% # Also changes class
    glimpse()

# Changing factor levels:
df <- starwars
df$sex <- as.factor(df$sex) # turns sex into a factor
levels(df$sex) # shows the levels of sex

df <- df %>% 
# Changes order of levels:
mutate(sex = factor(sex, 
                    levels = c("male", "female", "hermaphroditic", "none"
                    )))
levels(df$sex)

# Filtering rows:
starwars %>% 
    select(mass, sex) %>% 
    filter(mass < 55 & sex == "male") # filters to make everything less than 55 and all males

# Recoding data:
starwars %>% 
    select(sex) %>% 
    mutate(sex = recode(sex, "male" = "man", "female" = "woman"))

# Dealing with missing data:
mean(starwars$height) # doesn't work because of missing data

mean(starwars$height, na.rm = TRUE) # the extra line says to remove (rm) anything with a value of N/A (na), as it is set to TRUE

# Dealing with duplicates:
# Made up dataframe

Names <- c("Peter", "John", "Andrew", "Peter")
Age <- c(22, 33, 44, 22)

friends <- data.frame(Names, Age) # Peter is included twice

friends %>% 
    distinct() # leaves only distinct values
# 'distinct(friends)' also works for this as well

# Manipulating data:
# Using Star Wars dataset

# Create or changing a var:
starwars %>% 
    mutate(height_m = height/100) %>% # creating a var which is height in meters
    select(name, height, height_m)

# Conditional changes (if_else):
starwars %>% 
    mutate(height_m = height/100) %>% 
    select(name, height, height_m) %>% 
    # If height < 1 meter, label tallness as short, else tallness is tall. 
    mutate(tallness = if_else(height_m < 1, "short", "tall")) # categorizes whether short or tall if above or below 1m

# Reshaping data with Pivot wider:
library(gapminder) # dataset with country info, in long format
View(gapminder)

data <- select(gapminder, country, year, lifeExp)
View(data)

wide_data <- data %>% 
    pivot_wider(names_from = year, values_from = lifeExp) # reshapes data so columns are years and the cells are lifeExp
View(wide_data)

# Reshaping data with Pivot longer:
long_data <- wide_data %>% 
    pivot_longer(2:13, names_to = "year", values_to = "lifeExp") # restores to original
View(long_data)

# Describing data:
# Using msleep dataset

View(msleep)

# Range/Spread
min(msleep$awake)
max(msleep$awake)
range(msleep$awake)
IQR(masleep$awake)

# Centrality
mean(msleep$awake)
median(msleep$awake)

# Variance
var(msleep$awake)

# Summarizing all of the important values above:
summary(msleep$awake)

# Summary for two variables:
msleep %>% 
    select(awake, sleep_total) %>%
    summary()

# Making a table of summary values:
msleep %>% 
    drop_na(vore) %>% 
    group_by(vore) %>% 
    summarise(Lower = min(sleep_total),
            Average = mean(sleep_total),
            Upper = max(sleep_total),
            Difference = max(sleeptotal) - min(sleep_total)) %>% 
    arrange(Average) %>% 
    View()

# Creating tables:
table(msleep$vore)

msleep %>% 
    select(vore, order) %>% 
    # If 'Rodentia' or 'Primates' are in (%in%) order, include them
    filter(order %in% c("Rodentia", "Primates")) %>%
    arrange(Average) %>% 
    View()
table(msleep$score)

# Data visualization:
plot(pressure)

# Grammar of graphics:
    # data
    # mapping
    # geometry

# Bar plots:
library(ggplot)
ggplot(data = starwars, mapping = aes(x = gender)) +
    geom_bar

# Histograms:
starwars %>% 
    drop_na(height) %>% 
    ggplot(mapping = aes(x = height))+
    geom_histogram()

# Box plots:
starwars %>% 
    drop_na(height) %>% 
    ggplot(aes(height))+
    geom_boxplot(fill = "steelblue")+
    theme_bw()+
    labs(title = "Boxplot of Height", x = "Height of Characters")

# Density plots:
starwars %>% 
    drop_na(height) %>% 
    filter(sex %in% c("male", "female")) %>% # Only males and females
    ggplot(aes(height, color = sex, fill = sex)) +
    geom_density(alpha = 0.2) + # alpha is how dark the color would be
    theme_bw() # sets theme to black and white, adding a box around the graph

# Scatter plots:
starwars %>% 
    filter(mass<200) %>%
    ggplot(aes(height, mass, color = sex)) +
    geom_point(size = 5, alpha = 0.5) +
    theme_minimal() + # lacks box around the outside
    labs(title = "Height and Mass by Sex")

# Smoothed model:
starwars %>%
    filter(mass < 200) %>%
    ggplot(aes(height, mass, color = sex)) +
    geom_point(size = 3, alpha = 0.8) +
    geom_smooth() + # draws smooth linear model over points
    facet_wrap(~sex) + # made a new facet for each sex
    theme_bw() +
    labs(title = "Height and Mass by Sex")

# Analyzing data:
# Using gapminder dataset

gapminder %>%
    filter(continent %in% c("Africa", "Europe")) %>%
    t.test(lifeExp ~ continent, data= ., # t-test for lifeExp as a func of Continent
            alternative = "two.sided", # assumed
            paired = FALSE) # assumed

# Analysis of variance (ANOVA):

gapminder %>% 
    filter(year == 2007) %>% 
    filter(continent %in% c("Americas", "Europe", "Asia")) %>%
    aov(lifeExp ~ continent, data = .) %>%
    summary()

gapminder %>%
    filter(year == 2007) %>%
    filter(continent %in% c("Americas", "Europe", "Asia")) %>%
    aov(lifeExp ~ continent, data=.) %>%
    TukeyHSD() # considers each pairs seperately in t-test (pairing)
    plot()

# Chi-squared test:
# Using flower dataset
head(iris)

flowers <- iris %>%
    # Cut sepal length into three, with three intervals labeled small, medium and large
    mutate(Size = cut(Sepal.Length, breaks = 3, labels = c("Small", "Medium", "Large"))) %>%
    select(Species, Size)

# Chi-squared gooness of fit test:
flowers %>%
    select(Size) %>%
    table() %>%
    chisq.test()

# Chi-squared test of independence:
flowers %>%
    table() %>%
    chisq.test()

# Linear model:
# Using cars dataset

cars %>%
    lm(dist ~ speed, data = .) %>%
    summary()
