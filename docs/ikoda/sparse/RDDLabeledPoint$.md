<!DOCTYPE html >
<html>
        <head>
          <title>RDDLabeledPoint - ikodaSparse 1.0.0 API - ikoda.sparse.RDDLabeledPoint</title>
          <meta name="description" content="RDDLabeledPoint - ikodaSparse 1.0.0 API - ikoda.sparse.RDDLabeledPoint" />
          <meta name="keywords" content="RDDLabeledPoint ikodaSparse 1.0.0 API ikoda.sparse.RDDLabeledPoint" />
          <meta http-equiv="content-type" content="text/html; charset=UTF-8" />
          
      <link href="../../lib/template.css" media="screen" type="text/css" rel="stylesheet" />
      <link href="../../lib/diagrams.css" media="screen" type="text/css" rel="stylesheet" id="diagrams-css" />
      <script type="text/javascript" src="../../lib/jquery.js" id="jquery-js"></script>
      <script type="text/javascript" src="../../lib/jquery-ui.js"></script>
      <script type="text/javascript" src="../../lib/template.js"></script>
      <script type="text/javascript" src="../../lib/tools.tooltip.js"></script>
      
      <script type="text/javascript">
         if(top === self) {
            var url = '../../index.html';
            var hash = 'ikoda.sparse.RDDLabeledPoint$';
            var anchor = window.location.hash;
            var anchor_opt = '';
            if (anchor.length >= 1)
              anchor_opt = '@' + anchor.substring(1);
            window.location.href = url + '#' + hash + anchor_opt;
         }
   	  </script>
    
        </head>
        <body class="value">
      <div id="definition">
        <a href="RDDLabeledPoint.html" title="See companion class"><img alt="Object/Class" src="../../lib/object_to_class_big.png" /></a>
        <p id="owner"><a href="../package.html" class="extype" name="ikoda">ikoda</a>.<a href="package.html" class="extype" name="ikoda.sparse">sparse</a></p>
        <h1><a href="RDDLabeledPoint.html" title="See companion class">RDDLabeledPoint</a></h1><h3><span class="morelinks"><div>
            Related Docs:
            <a href="RDDLabeledPoint.html" title="See companion class">class RDDLabeledPoint</a>
            | <a href="package.html" class="extype" name="ikoda.sparse">package sparse</a>
          </div></span></h3><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      </div>

      <h4 id="signature" class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">object</span>
      </span>
      <span class="symbol">
        <span class="name">RDDLabeledPoint</span><span class="result"> extends <span class="extype" name="grizzled.slf4j.Logging">Logging</span> with <span class="extype" name="scala.Serializable">Serializable</span></span>
      </span>
      </h4>
      
          <div id="comment" class="fullcommenttop"><div class="comment cmt"></div><div class="toggleContainer block">
          <span class="toggle">Linear Supertypes</span>
          <div class="superTypes hiddenContent"><span class="extype" name="scala.Serializable">Serializable</span>, <span class="extype" name="java.io.Serializable">Serializable</span>, <span class="extype" name="grizzled.slf4j.Logging">Logging</span>, <span class="extype" name="scala.AnyRef">AnyRef</span>, <span class="extype" name="scala.Any">Any</span></div>
        </div></div>
        

      <div id="mbrsel">
        <div id="textfilter"><span class="pre"></span><span class="input"><input id="mbrsel-input" type="text" accesskey="/" /></span><span class="post"></span></div>
        <div id="order">
              <span class="filtertype">Ordering</span>
              <ol>
                <li class="group out"><span>Grouped</span></li>
                <li class="alpha in"><span>Alphabetic</span></li>
                <li class="inherit out"><span>By Inheritance</span></li>
              </ol>
            </div>
        <div id="ancestors">
                <span class="filtertype">Inherited<br />
                </span>
                <ol id="linearization">
                  <li class="in" name="ikoda.sparse.RDDLabeledPoint"><span>RDDLabeledPoint</span></li><li class="in" name="scala.Serializable"><span>Serializable</span></li><li class="in" name="java.io.Serializable"><span>Serializable</span></li><li class="in" name="grizzled.slf4j.Logging"><span>Logging</span></li><li class="in" name="scala.AnyRef"><span>AnyRef</span></li><li class="in" name="scala.Any"><span>Any</span></li>
                </ol>
              </div><div id="ancestors">
            <span class="filtertype"></span>
            <ol>
              <li class="hideall out"><span>Hide All</span></li>
              <li class="showall in"><span>Show All</span></li>
            </ol>
          </div>
        <div id="visbl">
            <span class="filtertype">Visibility</span>
            <ol><li class="public in"><span>Public</span></li><li class="all out"><span>All</span></li></ol>
          </div>
      </div>

      <div id="template">
        <div id="allMembers">
        

        <div id="types" class="types members">
              <h3>Type Members</h3>
              <ol><li name="ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="FTDoubleDouble_Double=(Double,Double)=&gt;Double"></a>
      <a id="FTDoubleDouble_Double:FTDoubleDouble_Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">type</span>
      </span>
      <span class="symbol">
        <span class="name">FTDoubleDouble_Double</span><span class="result"> = (<span class="extype" name="scala.Double">Double</span>, <span class="extype" name="scala.Double">Double</span>) ⇒ <span class="extype" name="scala.Double">Double</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@FTDoubleDouble_Double=(Double,Double)=&gt;Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li></ol>
            </div>

        

        <div id="values" class="values members">
              <h3>Value Members</h3>
              <ol><li name="scala.AnyRef#!=" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="!=(x$1:Any):Boolean"></a>
      <a id="!=(Any):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span title="gt4s: $bang$eq" class="name">!=</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@!=(x$1:Any):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="scala.AnyRef###" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="##():Int"></a>
      <a id="##():Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span title="gt4s: $hash$hash" class="name">##</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@##():Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="scala.AnyRef#==" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="==(x$1:Any):Boolean"></a>
      <a id="==(Any):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span title="gt4s: $eq$eq" class="name">==</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@==(x$1:Any):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#addColumn" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="addColumn(sparse0:ikoda.sparse.RDDLabeledPoint,col:Seq[ikoda.sparse.CellTuple],colName:String):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="addColumn(RDDLabeledPoint,Seq[CellTuple],String):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">addColumn</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="col">col: <span class="extype" name="scala.Seq">Seq</span>[<a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>, <span name="colName">colName: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@addColumn(sparse0:ikoda.sparse.RDDLabeledPoint,col:Seq[ikoda.sparse.CellTuple],colName:String):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Add a column  to the dataset.</p><div class="fullcomment"><div class="comment cmt"><p>Add a column  to the dataset. The number of CellTupls must much the number of rows in the dataset</p></div></div>
    </li><li name="scala.Any#asInstanceOf" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="asInstanceOf[T0]:T0"></a>
      <a id="asInstanceOf[T0]:T0"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">asInstanceOf</span><span class="tparams">[<span name="T0">T0</span>]</span><span class="result">: <span class="extype" name="scala.Any.asInstanceOf.T0">T0</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@asInstanceOf[T0]:T0" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#cleanLowerCaseColumns" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="cleanLowerCaseColumns(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="cleanLowerCaseColumns(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">cleanLowerCaseColumns</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@cleanLowerCaseColumns(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Utility method prepares column names to meet Cassandra conventions for column names</p>
    </li><li name="scala.AnyRef#clone" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="clone():Object"></a>
      <a id="clone():AnyRef"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">clone</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.AnyRef">AnyRef</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@clone():Object" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected[<a href="../../java$lang.html" class="extype" name="java.lang">java.lang</a>] </dd><dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="classOf[java.lang.CloneNotSupportedException]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#colMedian" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="colMedian(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]"></a>
      <a id="colMedian(RDDLabeledPoint):Map[Int,CellTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">colMedian</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Int">Int</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@colMedian(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns the median value for every column</p><div class="fullcomment"><div class="comment cmt"><p>Returns the median value for every column</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#colStDevs" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="colStDevs(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]"></a>
      <a id="colStDevs(RDDLabeledPoint):Map[Int,CellTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">colStDevs</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Int">Int</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@colStDevs(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The standard deviation for each column</p><div class="fullcomment"><div class="comment cmt"><p>The standard deviation for each column</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#colSums" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="colSums(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]"></a>
      <a id="colSums(RDDLabeledPoint):Map[Int,CellTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">colSums</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Int">Int</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@colSums(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Int,ikoda.sparse.CellTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The column sum for each column</p><div class="fullcomment"><div class="comment cmt"><p>The column sum for each column</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#columnCellOnColumnConstant" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="columnCellOnColumnConstant(sparse0:ikoda.sparse.RDDLabeledPoint,operation:ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double,constants:Map[Int,ikoda.sparse.CellTuple]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="columnCellOnColumnConstant(RDDLabeledPoint,FTDoubleDouble_Double,Map[Int,CellTuple]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnCellOnColumnConstant</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="operation">operation: <a href="#FTDoubleDouble_Double=(Double,Double)=&gt;Double" class="extmbr" name="ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double">FTDoubleDouble_Double</a></span>, <span name="constants">constants: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Int">Int</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@columnCellOnColumnConstant(sparse0:ikoda.sparse.RDDLabeledPoint,operation:ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double,constants:Map[Int,ikoda.sparse.CellTuple]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">See documentation.</p><div class="fullcomment"><div class="comment cmt"><p>See documentation. The map holds a constant (e.g., column sum) for every column. The operation method specifies a function to be performed on each cell in each column with the constant as the second parameter in the method
</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#countRowsByTarget" visbl="pub" data-isabs="false" fullComment="no" group="cpt">
      <a id="countRowsByTarget(sparse0:ikoda.sparse.RDDLabeledPoint):org.apache.spark.rdd.RDD[(Double,Int)]"></a>
      <a id="countRowsByTarget(RDDLabeledPoint):RDD[(Double,Int)]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">countRowsByTarget</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="org.apache.spark.rdd.RDD">RDD</span>[(<span class="extype" name="scala.Double">Double</span>, <span class="extype" name="scala.Int">Int</span>)]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@countRowsByTarget(sparse0:ikoda.sparse.RDDLabeledPoint):org.apache.spark.rdd.RDD[(Double,Int)]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The number of rows assigned to each target/label</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#countRowsByTargetCollected" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="countRowsByTargetCollected(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Double,Int]"></a>
      <a id="countRowsByTargetCollected(RDDLabeledPoint):Map[Double,Int]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">countRowsByTargetCollected</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Double">Double</span>, <span class="extype" name="scala.Int">Int</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@countRowsByTargetCollected(sparse0:ikoda.sparse.RDDLabeledPoint):Map[Double,Int]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">counts number of rows per target.</p><div class="fullcomment"><div class="comment cmt"><p>counts number of rows per target. Data is collected to driver before executing</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#debug" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="debug(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="debug(Marker,⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">debug</span><span class="params">(<span name="mkr">mkr: <span class="extype" name="org.slf4j.Marker">Marker</span></span>, <span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@debug(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#debug" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="debug(msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="debug(⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">debug</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@debug(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#debug" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="debug(msg:=&gt;Any):Unit"></a>
      <a id="debug(⇒Any):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">debug</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@debug(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#diagnostics" visbl="pub" data-isabs="false" fullComment="no" group="dp">
      <a id="diagnostics(sparse0:ikoda.sparse.RDDLabeledPoint):String"></a>
      <a id="diagnostics(RDDLabeledPoint):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">diagnostics</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@diagnostics(sparse0:ikoda.sparse.RDDLabeledPoint):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Reports on differences between the labeled point data and data in the column map and target map</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#dichotomizeTargetOrOther" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="dichotomizeTargetOrOther(sparse0:ikoda.sparse.RDDLabeledPoint,label:Double,stringLabel:String):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="dichotomizeTargetOrOther(RDDLabeledPoint,Double,String):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">dichotomizeTargetOrOther</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="label">label: <span class="extype" name="scala.Double">Double</span></span>, <span name="stringLabel">stringLabel: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@dichotomizeTargetOrOther(sparse0:ikoda.sparse.RDDLabeledPoint,label:Double,stringLabel:String):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Resets the label for all rows to OTHER except for the label specified as an input parameter</p><div class="fullcomment"><div class="comment cmt"><p>Resets the label for all rows to OTHER except for the label specified as an input parameter</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="scala.AnyRef#eq" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="eq(x$1:AnyRef):Boolean"></a>
      <a id="eq(AnyRef):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">eq</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.AnyRef">AnyRef</span></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@eq(x$1:AnyRef):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="scala.AnyRef#equals" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="equals(x$1:Any):Boolean"></a>
      <a id="equals(Any):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">equals</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@equals(x$1:Any):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#error" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="error(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="error(Marker,⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">error</span><span class="params">(<span name="mkr">mkr: <span class="extype" name="org.slf4j.Marker">Marker</span></span>, <span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@error(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#error" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="error(msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="error(⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">error</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@error(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#error" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="error(msg:=&gt;Any):Unit"></a>
      <a id="error(⇒Any):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">error</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@error(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#evenProportionPerTarget" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="evenProportionPerTarget(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="evenProportionPerTarget(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">evenProportionPerTarget</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@evenProportionPerTarget(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Reduces the number of rows for over-represented labels/categories.</p><div class="fullcomment"><div class="comment cmt"><p>Reduces the number of rows for over-represented labels/categories. Rows are randomly removed from
which belong to a category with rows above the median row count per target. All categories with a row count
above the median row count per category are reduced to approximate the median row count</p></div></div>
    </li><li name="scala.AnyRef#finalize" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="finalize():Unit"></a>
      <a id="finalize():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">finalize</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@finalize():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected[<a href="../../java$lang.html" class="extype" name="java.lang">java.lang</a>] </dd><dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[java.lang.Throwable]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="scala.AnyRef#getClass" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getClass():Class[_]"></a>
      <a id="getClass():Class[_]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getClass</span><span class="params">()</span><span class="result">: <span class="extype" name="java.lang.Class">Class</span>[_]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@getClass():Class[_]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#getRowsContainingColIdxAndMatchesLabelUnchangedSchema" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse0:ikoda.sparse.RDDLabeledPoint,colIdxSet:Set[Int],labelo:Option[Double]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="getRowsContainingColIdxAndMatchesLabelUnchangedSchema(RDDLabeledPoint,Set[Int],Option[Double]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getRowsContainingColIdxAndMatchesLabelUnchangedSchema</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="colIdxSet">colIdxSet: <span class="extype" name="scala.Predef.Set">Set</span>[<span class="extype" name="scala.Int">Int</span>]</span>, <span name="labelo">labelo: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Double">Double</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@getRowsContainingColIdxAndMatchesLabelUnchangedSchema(sparse0:ikoda.sparse.RDDLabeledPoint,colIdxSet:Set[Int],labelo:Option[Double]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A dataset of rows that have an active value for a specified column/feature.</p><div class="fullcomment"><div class="comment cmt"><p>A dataset of rows that have an active value for a specified column/feature. If the label is None
all rows are returned, otherwise the subset is also by label/target</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="scala.AnyRef#hashCode" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="hashCode():Int"></a>
      <a id="hashCode():Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">hashCode</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@hashCode():Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#info" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="info(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="info(Marker,⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">info</span><span class="params">(<span name="mkr">mkr: <span class="extype" name="org.slf4j.Marker">Marker</span></span>, <span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@info(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#info" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="info(msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="info(⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">info</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@info(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#info" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="info(msg:=&gt;Any):Unit"></a>
      <a id="info(⇒Any):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">info</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@info(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#inverseDocumentFrequency" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="inverseDocumentFrequency(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="inverseDocumentFrequency(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">inverseDocumentFrequency</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@inverseDocumentFrequency(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Takes sparse data that has already been normalized using termFrequencyNormalization.</p><div class="fullcomment"><div class="comment cmt"><p>Takes sparse data that has already been normalized using termFrequencyNormalization. Performs inverse document frequency</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#inverseDocumentFrequency" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="inverseDocumentFrequency(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="inverseDocumentFrequency(Option[RDDLabeledPoint]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">inverseDocumentFrequency</span><span class="params">(<span name="sparse0">sparse0: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@inverseDocumentFrequency(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Takes sparse data that has already been normalized using termFrequencyNormalization.</p><div class="fullcomment"><div class="comment cmt"><p>Takes sparse data that has already been normalized using termFrequencyNormalization. Performs inverse document frequency</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#isDebugEnabled" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isDebugEnabled:Boolean"></a>
      <a id="isDebugEnabled:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isDebugEnabled</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isDebugEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#isErrorEnabled" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isErrorEnabled:Boolean"></a>
      <a id="isErrorEnabled:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isErrorEnabled</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isErrorEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#isInfoEnabled" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isInfoEnabled:Boolean"></a>
      <a id="isInfoEnabled:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isInfoEnabled</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isInfoEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="scala.Any#isInstanceOf" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isInstanceOf[T0]:Boolean"></a>
      <a id="isInstanceOf[T0]:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isInstanceOf</span><span class="tparams">[<span name="T0">T0</span>]</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isInstanceOf[T0]:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>Any</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#isTraceEnabled" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isTraceEnabled:Boolean"></a>
      <a id="isTraceEnabled:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isTraceEnabled</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isTraceEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#isWarnEnabled" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="isWarnEnabled:Boolean"></a>
      <a id="isWarnEnabled:Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isWarnEnabled</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@isWarnEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadLibSvm" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="loadLibSvm(fileName:String,path:String,validateColumns:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadLibSvm(String,String,Boolean):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadLibSvm</span><span class="params">(<span name="fileName">fileName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="path">path: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="validateColumns">validateColumns: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">false</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadLibSvm(fileName:String,path:String,validateColumns:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads libsvm data from hadoop path.</p><div class="fullcomment"><div class="comment cmt"><p>Loads libsvm data from hadoop path. Companion files for column map and target map are expected
See documentation for explanation
validateColumns (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadLibSvmFromHelper" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="loadLibSvmFromHelper(data:org.apache.spark.sql.Dataset[(org.apache.spark.ml.feature.LabeledPoint,Int,String)],columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String,validateCompleteness:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadLibSvmFromHelper(Dataset[(LabeledPoint,Int,String)],ListMap[Int,ColumnHeadTuple],Map[String,Double],String,Boolean):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadLibSvmFromHelper</span><span class="params">(<span name="data">data: <span class="extype" name="org.apache.spark.sql.Dataset">Dataset</span>[(<span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span>, <span class="extype" name="scala.Int">Int</span>, <span class="extype" name="scala.Predef.String">String</span>)]</span>, <span name="columns">columns: <span class="extype" name="scala.collection.mutable.ListMap">ListMap</span>[<span class="extype" name="scala.Int">Int</span>, <a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>]</span>, <span name="targets">targets: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>, <span name="datasetName">datasetName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="validateCompleteness">validateCompleteness: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">false</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadLibSvmFromHelper(data:org.apache.spark.sql.Dataset[(org.apache.spark.ml.feature.LabeledPoint,Int,String)],columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String,validateCompleteness:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads libsvm data passed in as a DataSet and companion maps for column names and target names
The dataset name is a convenience parameter for tracking your data
validateCompleteness (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data</p><div class="fullcomment"><div class="comment cmt"><p>Loads libsvm data passed in as a DataSet and companion maps for column names and target names
The dataset name is a convenience parameter for tracking your data
validateCompleteness (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data</p><p>data:Dataset[(LabeledPoint,Int,String)],
columns:mutable.ListMap[Int,ColumnHeadTuple],
targets:Map[String,Double],
datasetName:String,
validateCompleteness:Boolean=false</p><p>See documentation for explanation</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadLibSvmFromHelper1" visbl="pub" data-isabs="false" fullComment="no" group="load">
      <a id="loadLibSvmFromHelper1(data:org.apache.spark.rdd.RDD[org.apache.spark.ml.feature.LabeledPoint],columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String,validateCompleteness:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadLibSvmFromHelper1(RDD[LabeledPoint],ListMap[Int,ColumnHeadTuple],Map[String,Double],String,Boolean):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadLibSvmFromHelper1</span><span class="params">(<span name="data">data: <span class="extype" name="org.apache.spark.rdd.RDD">RDD</span>[<span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span>]</span>, <span name="columns">columns: <span class="extype" name="scala.collection.mutable.ListMap">ListMap</span>[<span class="extype" name="scala.Int">Int</span>, <a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>]</span>, <span name="targets">targets: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>, <span name="datasetName">datasetName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="validateCompleteness">validateCompleteness: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">false</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadLibSvmFromHelper1(data:org.apache.spark.rdd.RDD[org.apache.spark.ml.feature.LabeledPoint],columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String,validateCompleteness:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads libsvm data passed in as a DataSet and companion maps for column names and target names
The dataset name is a convenience parameter for tracking your data
validateCompleteness (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data
Refer to documentation for explanation</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadLibSvmLocal" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="loadLibSvmLocal(inpth:String,validateColumns:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadLibSvmLocal(String,Boolean):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadLibSvmLocal</span><span class="params">(<span name="inpth">inpth: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="validateColumns">validateColumns: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">true</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadLibSvmLocal(inpth:String,validateColumns:Boolean):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads libsvm data from local path.</p><div class="fullcomment"><div class="comment cmt"><p>Loads libsvm data from local path. Companion files for column map and target map are expected
See documentation for explanation
validateColumns (optional), if true, checks that column count in the column map matches total column/feature count in the LabeledPoint data</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadLibSvmSchemaFromHelper1" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="loadLibSvmSchemaFromHelper1(columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadLibSvmSchemaFromHelper1(ListMap[Int,ColumnHeadTuple],Map[String,Double],String):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadLibSvmSchemaFromHelper1</span><span class="params">(<span name="columns">columns: <span class="extype" name="scala.collection.mutable.ListMap">ListMap</span>[<span class="extype" name="scala.Int">Int</span>, <a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>]</span>, <span name="targets">targets: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>, <span name="datasetName">datasetName: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadLibSvmSchemaFromHelper1(columns:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple],targets:Map[String,Double],datasetName:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads the column map and target map input variables.</p><div class="fullcomment"><div class="comment cmt"><p>Loads the column map and target map input variables.</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadSchema1" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="loadSchema1(fileName:String,path:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadSchema1(String,String):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadSchema1</span><span class="params">(<span name="fileName">fileName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="path">path: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadSchema1(fileName:String,path:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads the column map and target map from hadoop but NOT the data.</p><div class="fullcomment"><div class="comment cmt"><p>Loads the column map and target map from hadoop but NOT the data.</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#loadSchemaLocal" visbl="pub" data-isabs="false" fullComment="no" group="load">
      <a id="loadSchemaLocal(inpth:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="loadSchemaLocal(String):Try[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loadSchemaLocal</span><span class="params">(<span name="inpth">inpth: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loadSchemaLocal(inpth:String):scala.util.Try[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Loads the column map and target map from local drive but NOT the data.</p>
    </li><li name="grizzled.slf4j.Logging#logger" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="logger:grizzled.slf4j.Logger"></a>
      <a id="logger:Logger"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">logger</span><span class="result">: <span class="extype" name="grizzled.slf4j.Logger">Logger</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@logger:grizzled.slf4j.Logger" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#loggerName" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="loggerName:String"></a>
      <a id="loggerName:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">loggerName</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@loggerName:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#mergeTarget" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="mergeTarget(sparse0:ikoda.sparse.RDDLabeledPoint,oldTargetIdx:Double,newTargetIdx:Double):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="mergeTarget(RDDLabeledPoint,Double,Double):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">mergeTarget</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="oldTargetIdx">oldTargetIdx: <span class="extype" name="scala.Double">Double</span></span>, <span name="newTargetIdx">newTargetIdx: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@mergeTarget(sparse0:ikoda.sparse.RDDLabeledPoint,oldTargetIdx:Double,newTargetIdx:Double):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Merge two targets so the old target is replaced with the new target</p><div class="fullcomment"><div class="comment cmt"><p>Merge two targets so the old target is replaced with the new target</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[ikoda.IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="scala.AnyRef#ne" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="ne(x$1:AnyRef):Boolean"></a>
      <a id="ne(AnyRef):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">ne</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.AnyRef">AnyRef</span></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@ne(x$1:AnyRef):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="scala.AnyRef#notify" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="notify():Unit"></a>
      <a id="notify():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">notify</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@notify():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="scala.AnyRef#notifyAll" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="notifyAll():Unit"></a>
      <a id="notifyAll():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">notifyAll</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@notifyAll():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#printSparse" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="printSparse(sparse0:ikoda.sparse.RDDLabeledPoint,fileName:String,inpath:String,coalesce:Boolean):Unit"></a>
      <a id="printSparse(RDDLabeledPoint,String,String,Boolean):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">printSparse</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="fileName">fileName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="inpath">inpath: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="coalesce">coalesce: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">false</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@printSparse(sparse0:ikoda.sparse.RDDLabeledPoint,fileName:String,inpath:String,coalesce:Boolean):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Saves data to a local file system.</p><div class="fullcomment"><div class="comment cmt"><p>Saves data to a local file system.</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#printSparseLocally" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="printSparseLocally(sparse0:Option[ikoda.sparse.RDDLabeledPoint],fileName:String,inpath:String,truncateAt:Option[Int]):Unit"></a>
      <a id="printSparseLocally(Option[RDDLabeledPoint],String,String,Option[Int]):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">printSparseLocally</span><span class="params">(<span name="sparse0">sparse0: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>, <span name="fileName">fileName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="inpath">inpath: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="truncateAt">truncateAt: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Int">Int</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@printSparseLocally(sparse0:Option[ikoda.sparse.RDDLabeledPoint],fileName:String,inpath:String,truncateAt:Option[Int]):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Saves data to a local file system</p><div class="fullcomment"><div class="comment cmt"><p>Saves data to a local file system</p></div><dl class="paramcmts block"><dt class="param">truncateAt</dt><dd class="cmt"><p>The number of decimal points to keep in the output (Truncated, not rounded)</p></dd></dl><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#printSparseLocally" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="printSparseLocally(sparse0:ikoda.sparse.RDDLabeledPoint,fileName:String,inpath:String,truncateAt:Int):Unit"></a>
      <a id="printSparseLocally(RDDLabeledPoint,String,String,Int):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">printSparseLocally</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="fileName">fileName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="inpath">inpath: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="truncateAt">truncateAt: <span class="extype" name="scala.Int">Int</span> = <span class="symbol">0</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@printSparseLocally(sparse0:ikoda.sparse.RDDLabeledPoint,fileName:String,inpath:String,truncateAt:Int):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Saves data to a local file system.</p><div class="fullcomment"><div class="comment cmt"><p>Saves data to a local file system.</p></div><dl class="paramcmts block"><dt class="param">truncateAt</dt><dd class="cmt"><p>The number of decimal points to keep in the output (Truncated, not rounded)</p></dd></dl><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#proportionOfColumnWithValues" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="proportionOfColumnWithValues(sparse0:ikoda.sparse.RDDLabeledPoint,ignoreCol:String):Seq[(Int,Double)]"></a>
      <a id="proportionOfColumnWithValues(RDDLabeledPoint,String):Seq[(Int,Double)]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">proportionOfColumnWithValues</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="ignoreCol">ignoreCol: <span class="extype" name="scala.Predef.String">String</span> = <span class="symbol">&quot;&quot;</span></span>)</span><span class="result">: <span class="extype" name="scala.Seq">Seq</span>[(<span class="extype" name="scala.Int">Int</span>, <span class="extype" name="scala.Double">Double</span>)]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@proportionOfColumnWithValues(sparse0:ikoda.sparse.RDDLabeledPoint,ignoreCol:String):Seq[(Int,Double)]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The proportion of non-zero values in each column</p><div class="fullcomment"><div class="comment cmt"><p>The proportion of non-zero values in each column</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#randomSubset" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="randomSubset(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="randomSubset(RDDLabeledPoint,Double):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">randomSubset</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="proportion">proportion: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@randomSubset(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns a random subset</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#randomSubsetWithColumnRealignment" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="randomSubsetWithColumnRealignment(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="randomSubsetWithColumnRealignment(RDDLabeledPoint,Double):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">randomSubsetWithColumnRealignment</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="proportion">proportion: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@randomSubsetWithColumnRealignment(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns a random subset with columns reassigned to sequential order</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#reduceToTargetBySum1" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="reduceToTargetBySum1(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="reduceToTargetBySum1(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">reduceToTargetBySum1</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@reduceToTargetBySum1(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Reduces all rows for a give target/label to a single row by summing the values for each column/feature</p><div class="fullcomment"><div class="comment cmt"><p>Reduces all rows for a give target/label to a single row by summing the values for each column/feature</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeColumnsDistributed" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="removeColumnsDistributed(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int],failOnError:Boolean):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeColumnsDistributed(RDDLabeledPoint,Set[Int],Boolean):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">removeColumnsDistributed</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="columnIndices">columnIndices: <span class="extype" name="scala.Predef.Set">Set</span>[<span class="extype" name="scala.Int">Int</span>]</span>, <span name="failOnError">failOnError: <span class="extype" name="scala.Boolean">Boolean</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeColumnsDistributed(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int],failOnError:Boolean):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes columns/features from the dataset.</p><div class="fullcomment"><div class="comment cmt"><p>Removes columns/features from the dataset. Column indices are not re-aligned after column removal.
If failOnError == true, the method returns None when it encounters an invalid column/feature. Otherwise, the
invalid column index is ignored</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeColumnsDistributed" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="removeColumnsDistributed(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeColumnsDistributed(RDDLabeledPoint,Set[Int]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">removeColumnsDistributed</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="columnIndices">columnIndices: <span class="extype" name="scala.Predef.Set">Set</span>[<span class="extype" name="scala.Int">Int</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeColumnsDistributed(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes columns/features from the dataset.</p><div class="fullcomment"><div class="comment cmt"><p>Removes columns/features from the dataset. Column indices are not re-aligned after column removal</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeDuplicateRows" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="removeDuplicateRows(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeDuplicateRows(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">removeDuplicateRows</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeDuplicateRows(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes all duplicate rows</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeRowsByHashcode" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="removeRowsByHashcode(sparse0:ikoda.sparse.RDDLabeledPoint,hcToRemove:Seq[Int]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeRowsByHashcode(RDDLabeledPoint,Seq[Int]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">removeRowsByHashcode</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="hcToRemove">hcToRemove: <span class="extype" name="scala.Seq">Seq</span>[<span class="extype" name="scala.Int">Int</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeRowsByHashcode(sparse0:ikoda.sparse.RDDLabeledPoint,hcToRemove:Seq[Int]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes all rows  with hashcodes specified in hcToRemove.</p><div class="fullcomment"><div class="comment cmt"><p>Removes all rows  with hashcodes specified in hcToRemove. (Useful to remove duplicate rows)</p></div></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeRowsByLabels" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="removeRowsByLabels(sparse0:ikoda.sparse.RDDLabeledPoint,labelsToRemove:Seq[Double]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeRowsByLabels(RDDLabeledPoint,Seq[Double]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">removeRowsByLabels</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="labelsToRemove">labelsToRemove: <span class="extype" name="scala.Seq">Seq</span>[<span class="extype" name="scala.Double">Double</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeRowsByLabels(sparse0:ikoda.sparse.RDDLabeledPoint,labelsToRemove:Seq[Double]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes all rows assigned to the labels specified in labelsToRemove</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#renameTargetsInNumericOrder" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="renameTargetsInNumericOrder(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="renameTargetsInNumericOrder(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">renameTargetsInNumericOrder</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@renameTargetsInNumericOrder(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Renames targets in numeric order</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#resetColumnIndices" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="resetColumnIndices(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="resetColumnIndices(Option[RDDLabeledPoint]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">resetColumnIndices</span><span class="params">(<span name="sparse0">sparse0: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@resetColumnIndices(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Resets column indices in ascending numeric order</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#resetColumnIndices" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="resetColumnIndices(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="resetColumnIndices(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">resetColumnIndices</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@resetColumnIndices(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Resets column indices in ascending numeric order</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#rowCellOnRowConstant1" visbl="pub" data-isabs="false" fullComment="no" group="cpt">
      <a id="rowCellOnRowConstant1(sparse0:ikoda.sparse.RDDLabeledPoint,operation:ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double,constants:scala.collection.mutable.HashMap[Double,ikoda.sparse.CellTuple]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="rowCellOnRowConstant1(RDDLabeledPoint,FTDoubleDouble_Double,HashMap[Double,CellTuple]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">rowCellOnRowConstant1</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="operation">operation: <a href="#FTDoubleDouble_Double=(Double,Double)=&gt;Double" class="extmbr" name="ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double">FTDoubleDouble_Double</a></span>, <span name="constants">constants: <span class="extype" name="scala.collection.mutable.HashMap">HashMap</span>[<span class="extype" name="scala.Double">Double</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@rowCellOnRowConstant1(sparse0:ikoda.sparse.RDDLabeledPoint,operation:ikoda.sparse.RDDLabeledPoint.FTDoubleDouble_Double,constants:scala.collection.mutable.HashMap[Double,ikoda.sparse.CellTuple]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Performs a computation on every cell in every row, with a unique constant for each row provided as an input parameter</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#rowSums" visbl="pub" data-isabs="false" fullComment="no" group="cpt">
      <a id="rowSums(sparse0:ikoda.sparse.RDDLabeledPoint):scala.collection.mutable.HashMap[Double,ikoda.sparse.CellTuple]"></a>
      <a id="rowSums(RDDLabeledPoint):HashMap[Double,CellTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">rowSums</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.collection.mutable.HashMap">HashMap</span>[<span class="extype" name="scala.Double">Double</span>, <a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@rowSums(sparse0:ikoda.sparse.RDDLabeledPoint):scala.collection.mutable.HashMap[Double,ikoda.sparse.CellTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A row sum value for each row</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#sampleDebug" visbl="pub" data-isabs="false" fullComment="no" group="dp">
      <a id="sampleDebug(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):String"></a>
      <a id="sampleDebug(RDDLabeledPoint,Double):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">sampleDebug</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="proportion">proportion: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@sampleDebug(sparse0:ikoda.sparse.RDDLabeledPoint,proportion:Double):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A print out of a certain propertion of the dataset</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#soMergeTargets" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="soMergeTargets(sparse0:ikoda.sparse.RDDLabeledPoint,oldnew:Map[Double,Double]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="soMergeTargets(RDDLabeledPoint,Map[Double,Double]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">soMergeTargets</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="oldnew">oldnew: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Double">Double</span>, <span class="extype" name="scala.Double">Double</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@soMergeTargets(sparse0:ikoda.sparse.RDDLabeledPoint,oldnew:Map[Double,Double]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Merge targets.</p><div class="fullcomment"><div class="comment cmt"><p>Merge targets. The old target will be renamed to match the new target</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#subsetByTarget" visbl="pub" data-isabs="false" fullComment="no" group="man">
      <a id="subsetByTarget(sparse0:ikoda.sparse.RDDLabeledPoint,label:Double,stringLabel:String):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="subsetByTarget(RDDLabeledPoint,Double,String):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">subsetByTarget</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="label">label: <span class="extype" name="scala.Double">Double</span></span>, <span name="stringLabel">stringLabel: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@subsetByTarget(sparse0:ikoda.sparse.RDDLabeledPoint,label:Double,stringLabel:String):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A subset including all rows for the specified label/target</p>
    </li><li name="scala.AnyRef#synchronized" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="synchronized[T0](x$1:=&gt;T0):T0"></a>
      <a id="synchronized[T0](⇒T0):T0"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">synchronized</span><span class="tparams">[<span name="T0">T0</span>]</span><span class="params">(<span name="arg0">arg0: ⇒ <span class="extype" name="java.lang.AnyRef.synchronized.T0">T0</span></span>)</span><span class="result">: <span class="extype" name="java.lang.AnyRef.synchronized.T0">T0</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@synchronized[T0](x$1:=&gt;T0):T0" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#termFrequencyNormalization" visbl="pub" data-isabs="false" fullComment="no" group="cpt">
      <a id="termFrequencyNormalization(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="termFrequencyNormalization(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">termFrequencyNormalization</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@termFrequencyNormalization(sparse0:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The first step in a TF-IDF computation</p>
    </li><li name="ikoda.sparse.RDDLabeledPoint#termFrequencyNormalization" visbl="pub" data-isabs="false" fullComment="no" group="cpt">
      <a id="termFrequencyNormalization(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="termFrequencyNormalization(Option[RDDLabeledPoint]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">termFrequencyNormalization</span><span class="params">(<span name="sparse0">sparse0: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@termFrequencyNormalization(sparse0:Option[ikoda.sparse.RDDLabeledPoint]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The first step in a TF-IDF computation</p>
    </li><li name="scala.AnyRef#toString" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="toString():String"></a>
      <a id="toString():String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">toString</span><span class="params">()</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@toString():String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#trace" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="trace(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="trace(Marker,⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">trace</span><span class="params">(<span name="mkr">mkr: <span class="extype" name="org.slf4j.Marker">Marker</span></span>, <span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@trace(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#trace" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="trace(msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="trace(⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">trace</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@trace(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#trace" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="trace(msg:=&gt;Any):Unit"></a>
      <a id="trace(⇒Any):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">trace</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@trace(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#validateSparseDataSchemaMatch" visbl="pub" data-isabs="false" fullComment="yes" group="load">
      <a id="validateSparseDataSchemaMatch(sparse0:ikoda.sparse.RDDLabeledPoint,sparse1:ikoda.sparse.RDDLabeledPoint):Boolean"></a>
      <a id="validateSparseDataSchemaMatch(RDDLabeledPoint,RDDLabeledPoint):Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">validateSparseDataSchemaMatch</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="sparse1">sparse1: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@validateSparseDataSchemaMatch(sparse0:ikoda.sparse.RDDLabeledPoint,sparse1:ikoda.sparse.RDDLabeledPoint):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Saves data to Hadoop</p><div class="fullcomment"><div class="comment cmt"><p>Saves data to Hadoop</p></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="scala.AnyRef#wait" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="wait():Unit"></a>
      <a id="wait():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">wait</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@wait():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="classOf[java.lang.InterruptedException]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="scala.AnyRef#wait" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="wait(x$1:Long,x$2:Int):Unit"></a>
      <a id="wait(Long,Int):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">wait</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.Long">Long</span></span>, <span name="arg1">arg1: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@wait(x$1:Long,x$2:Int):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="classOf[java.lang.InterruptedException]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="scala.AnyRef#wait" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="wait(x$1:Long):Unit"></a>
      <a id="wait(Long):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">final </span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">wait</span><span class="params">(<span name="arg0">arg0: <span class="extype" name="scala.Long">Long</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@wait(x$1:Long):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="classOf[java.lang.InterruptedException]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#warn" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="warn(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="warn(Marker,⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">warn</span><span class="params">(<span name="mkr">mkr: <span class="extype" name="org.slf4j.Marker">Marker</span></span>, <span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@warn(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#warn" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="warn(msg:=&gt;Any,t:=&gt;Throwable):Unit"></a>
      <a id="warn(⇒Any,⇒Throwable):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">warn</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>, <span name="t">t: ⇒ <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@warn(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="grizzled.slf4j.Logging#warn" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="warn(msg:=&gt;Any):Unit"></a>
      <a id="warn(⇒Any):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">warn</span><span class="params">(<span name="msg">msg: ⇒ <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@warn(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li></ol>
            </div>

        

        <div id="values" class="values members">
              <h3>Deprecated Value Members</h3>
              <ol><li name="ikoda.sparse.RDDLabeledPoint#removeColumnsCollected" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="removeColumnsCollected(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeColumnsCollected(RDDLabeledPoint,Set[Int]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name deprecated" title="Deprecated: ">removeColumnsCollected</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="columnIndices">columnIndices: <span class="extype" name="scala.Predef.Set">Set</span>[<span class="extype" name="scala.Int">Int</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeColumnsCollected(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:Set[Int]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes columns/features from the dataset.</p><div class="fullcomment"><div class="comment cmt"><p>Removes columns/features from the dataset. Column indices are not re-aligned after column removal</p></div><dl class="attributes block"> <dt>Deprecated</dt><dd class="cmt"></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint#removeColumnsCollected" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="removeColumnsCollected(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:scala.collection.mutable.Queue[Int]):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="removeColumnsCollected(RDDLabeledPoint,Queue[Int]):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name deprecated" title="Deprecated: ">removeColumnsCollected</span><span class="params">(<span name="sparse0">sparse0: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="columnIndices">columnIndices: <span class="extype" name="scala.collection.mutable.Queue">Queue</span>[<span class="extype" name="scala.Int">Int</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPoint$@removeColumnsCollected(sparse0:ikoda.sparse.RDDLabeledPoint,columnIndices:scala.collection.mutable.Queue[Int]):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Removes columns/features from the dataset.</p><div class="fullcomment"><div class="comment cmt"><p>Removes columns/features from the dataset. Column indices are not re-aligned after column removal</p></div><dl class="attributes block"> <dt>Deprecated</dt><dd class="cmt"></dd></dl></div>
    </li></ol>
            </div>
        </div>

        <div id="inheritedMembers">
        <div class="parent" name="scala.Serializable">
              <h3>Inherited from <span class="extype" name="scala.Serializable">Serializable</span></h3>
            </div><div class="parent" name="java.io.Serializable">
              <h3>Inherited from <span class="extype" name="java.io.Serializable">Serializable</span></h3>
            </div><div class="parent" name="grizzled.slf4j.Logging">
              <h3>Inherited from <span class="extype" name="grizzled.slf4j.Logging">Logging</span></h3>
            </div><div class="parent" name="scala.AnyRef">
              <h3>Inherited from <span class="extype" name="scala.AnyRef">AnyRef</span></h3>
            </div><div class="parent" name="scala.Any">
              <h3>Inherited from <span class="extype" name="scala.Any">Any</span></h3>
            </div>
        
        </div>

        <div id="groupedMembers">
        <div class="group" name="cpt">
              <h3>Data Computation</h3>
              
            </div><div class="group" name="dp">
              <h3>Data Attributes</h3>
              
            </div><div class="group" name="load">
              <h3>Loading and Saving</h3>
              
            </div><div class="group" name="man">
              <h3>Data Manipulation</h3>
              
            </div><div class="group" name="Ungrouped">
              <h3>Ungrouped</h3>
              
            </div>
        </div>

      </div>

      <div id="tooltip"></div>

      <div id="footer">  </div>


    </body>
      </html>
