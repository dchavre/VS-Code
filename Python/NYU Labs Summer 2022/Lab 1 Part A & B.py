# Assigning the variables as floats at the same time as collecting their values:
annual_salary = float(input('Starting annual salary: '))
portion_saved = float(input('Percent of salary saved as a decimal: '))
total_cost = float(input('Cost of your dream home: '))
semi_annual_raise = float(input('Semi-annual salary raise as a decimal: '))

down_payment_percentage = 0.15
current_savings = 0
r = 0.04

months = 0 # Making months a global variable to call to it again after the while loop 

# Calculating cost of the house:
total_cost *= down_payment_percentage

while total_cost >= current_savings:
    months += 1
    # Part B Corrections \/
    if months % 6 == 0:
        annual_salary *= (semi_annual_raise + 1)
    # Part B Corrections /\
    current_savings *= (1 + r / 12)
    current_savings += annual_salary / 12 * portion_saved

print('It will take ' + str(months)+ ' months')