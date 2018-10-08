# ikodaSparse
ikodaSparse maintains sparse data along with its meaningful text values. As an example, this allows natural language word frequency data to be processed in libsvm format while maintaining the words as column heads and categories as text values.
ikodaSparse is a Scala tool designed to run as part of a data pipeline on Spark.
The core of the tool is an `RDD[org.apache.spark.ml.feature.LabeledPoint]` with a mapping for text names to each column and label/target.
ikodaSparse also converts the data to both `DataFrame` and `RDD[org.apache.spark.mllib.regression.LabeledPoint]`if required

The main function of ikodaSparse is to manipulate large sparse data. ikodaSparse can:
1. Remove columns
2. Reorder columns
3. Remove rows by label/target
4. Perform mathematical operations both row wise and column wise
5. Merge labels/targets.
6. Merge data schemas. (i.e., convert one data set to match the column and target numbers of another).
7. Dichotomize labels/targets.(i.e., It is either of target A or OTHER)
8. Identify and remove duplicate rows
9. Return rows containing a particular column.
10. Add columns.



Sparse data is loaded from three files. 

*A libsvm file:*

42.0 12:1.0 78:2.0 258:1.0 275:1.0 302:1.0 348:1.0 362:1.0 492:1.0 494:1.0 642:1.0 1325:1.0 1583:1.0 2376:1.0 2501:1.0<br> 
42.0 151:1.0 415:1.0 907:1.0 9626:1.0<br>
4.0 48:1.0 211:1.0 881:1.0 6957:1.0 12667:1.0 15066:1.0

*A columnMap:*

ColumnHeadTuple(1,v_create)<br>
ColumnHeadTuple(2,scenario)<br>
ColumnHeadTuple(3,v_stimulate)<br>
ColumnHeadTuple(4,v_extract)<br>

In this case, the first column/feature, represented by 1 in the libsvm file, is the verb "create"

*A label/target/category map:*

(life sciences,42.0)<br>
(nursing,4.0)<br>
(business,16.0)<br>

In this case, the label represented by 42 in the libsvm file is "life sciences" (Perhaps the data here is natural language discussions of professions or college majors)

On Hadoop, the three data sources must have the same file name and must use the following suffixes
e.g., `mydata`, `mydata-columnMap` and `mydata-targetMap`
  
When opened from a local file system, the data will also include Windows friendly suffixes `.libsvm` for the sparseData and `.txt` for the two maps. e.g., `mydata.libsvm`, `mydata-columnMap.txt` and `mydata-targetMap.txt`



