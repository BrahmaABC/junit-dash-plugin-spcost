# Dash

[<img src="https://travis-ci.org/rbuck/junit-dash-plugin-spcost.svg?branch=master" alt="Build Status" />](http://travis-ci.org/rbuck/junit-dash-plugin-spcost)

## Description

Performance test comparing NuoDB Java-based stored procedure overhead versus
a standard SQL statement.

## Demo Execution

Follow these steps to run the demo:

1. Install the plugin into Dash
2. Create a database:
    `./spcost/manage.sh create`
3. Load the stored procedure:
    `./spcost/manage.sh load_stored_procedure`
4. Run the application:
    `./run.sh -t MIX`

### Results

Here are the results of this demo with 2.1.1-10:

    bash$ ./run.sh -t MIX
    Name        Count       Rate        Min      Max      Mean     Std Dev  Median   75%      95%      98%      99%      99.9%
    LIS         26477       3708        0.20     188.71   2.96     8.04     1.98     2.86     6.35     11.13    20.28    186.71
    SPC         27110       3795        0.75     158.07   4.28     9.68     2.56     3.98     9.42     20.31    40.21    156.95
    LIS         57726       4755        0.20     91.91    2.43     3.72     1.86     2.74     5.43     7.88     11.80    90.41
    SPC         58697       4834        0.62     114.70   3.56     6.42     2.53     3.75     7.68     12.44    21.75    114.47
    ...
    LIS         1799864     6057        0.25     14.81    2.18     1.68     1.87     2.68     4.91     7.12     10.20    14.77
    SPC         1835781     6178        0.65     24.23    2.98     2.12     2.44     3.63     6.72     9.36     11.62    24.03
    LIS         1830539     6058        0.25     14.81    2.19     1.67     1.91     2.69     4.78     7.12     10.20    14.77
    SPC         1866673     6178        0.65     24.23    2.97     2.05     2.47     3.59     6.61     8.80     10.80    24.00

    Time: 302.189

    OK (1 test)
