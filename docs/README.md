# ikodaSparse
**ikodaSparse maintains sparse data along with its meaningful text values.**

**`Libsvm` format data (and the analogous `LabeledPoint` Scala class) do not maintain  meaningful text values for columns or rows. They are purely numeric. In contrast, ikodaSparse maintains the text values for features/columns and text category names for the labels/targets.** 

As an example, this allows natural language word frequency data to be processed in libsvm format without losing the meaningful information required when reporting and providing data visualization of the data analysis.

ikodaSparse is a Scala tool designed to run as part of a data pipeline on Spark.

The core of the tool is an `RDD[org.apache.spark.ml.feature.LabeledPoint]` with a mapping for text names to each column and also  to each label/target.

ikodaSparse also converts the data to both `DataFrame` and `RDD[org.apache.spark.mllib.regression.LabeledPoint]`if required

The main function of ikodaSparse is to manipulate large sparse data. 

### ikodaSparse can:
1. Maintain a map of numeric feature identifiers with text names
1. Maintain a map of numeric labels/targets with text labels
1. Maintain a UUID for each row
1. Remove columns/features
1. Reorder columns/features
1. Add columns
1. Remove rows by label/target
1. Perform mathematical operations, both row wise and column wise
1. Provide data directly to scala ML functions
1. Merge labels/targets.
1. Merge data schemas. (i.e., convert one data set to match the column and target numbers of another).
1. Merge sparse data from two sources
1. Dichotomize labels/targets.(i.e., It is either of target A or OTHER)
1. Identify and remove duplicate rows
1. Return rows containing a particular column.
1. Load and save data on a local file system
1. Load and save data on Hadoop.


### <a href="https://github.com/amerywu/ikodaSparse/wiki">See Simple Guide to ikodaSparse for details</a>

##### <a href="./scaladoc/index.html">View ikodaSparse API (See class and object RDDLabeledPoint)  </a>


