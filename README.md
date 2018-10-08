# ikodaSparse
ikodaSparse maintains sparse data along with its meaningful text values. As an example, this allows natural language word frequency data to be processed in libsvm format while maintaining the words as column heads and categories as text values.

Sparse data is loaded from three files. 
A libsvm file with .libsvm file suffix (e.g., mydata.libsvm)

> 42.0 12:1.0 78:2.0 258:1.0 275:1.0 302:1.0 348:1.0 362:1.0 492:1.0 494:1.0 642:1.0 1325:1.0 1583:1.0 2376:1.0 2501:1.0 2993:1.0 3533:1.0 6175:1.0 8602:1.0 8802:1.0 10681:1.0
> 42.0 151:1.0 415:1.0 907:1.0 9626:1.0
> 4.0 48:1.0 211:1.0 881:1.0 6957:1.0 12667:1.0 15066:1.0
