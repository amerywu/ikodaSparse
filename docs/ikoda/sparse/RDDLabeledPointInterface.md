<!DOCTYPE html >
<html>
        <head>
          <title>RDDLabeledPointInterface - ikodaSparse 1.0.0 API - ikoda.sparse.RDDLabeledPointInterface</title>
          <meta name="description" content="RDDLabeledPointInterface - ikodaSparse 1.0.0 API - ikoda.sparse.RDDLabeledPointInterface" />
          <meta name="keywords" content="RDDLabeledPointInterface ikodaSparse 1.0.0 API ikoda.sparse.RDDLabeledPointInterface" />
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
            var hash = 'ikoda.sparse.RDDLabeledPointInterface';
            var anchor = window.location.hash;
            var anchor_opt = '';
            if (anchor.length >= 1)
              anchor_opt = '@' + anchor.substring(1);
            window.location.href = url + '#' + hash + anchor_opt;
         }
   	  </script>
    
        </head>
        <body class="type">
      <div id="definition">
        <img alt="Class" src="../../lib/class_big.png" />
        <p id="owner"><a href="../package.html" class="extype" name="ikoda">ikoda</a>.<a href="package.html" class="extype" name="ikoda.sparse">sparse</a></p>
        <h1>RDDLabeledPointInterface</h1><h3><span class="morelinks"><div>Related Doc:
            <a href="package.html" class="extype" name="ikoda.sparse">package sparse</a>
          </div></span></h3><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      </div>

      <h4 id="signature" class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <span class="name">RDDLabeledPointInterface</span><span class="result"> extends <a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a> with <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></span>
      </span>
      </h4>
      
          <div id="comment" class="fullcommenttop"><div class="toggleContainer block">
          <span class="toggle">Linear Supertypes</span>
          <div class="superTypes hiddenContent"><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a>, <a href="RDDLabeledPointDataLoader.html" class="extype" name="ikoda.sparse.RDDLabeledPointDataLoader">RDDLabeledPointDataLoader</a>, <a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a>, <a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a>, <a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a>, <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a>, <span class="extype" name="grizzled.slf4j.Logging">Logging</span>, <span class="extype" name="scala.Serializable">Serializable</span>, <span class="extype" name="java.io.Serializable">Serializable</span>, <span class="extype" name="scala.AnyRef">AnyRef</span>, <span class="extype" name="scala.Any">Any</span></div>
        </div><div class="toggleContainer block">
            <span class="toggle">Known Subclasses</span>
            <div class="subClasses hiddenContent"><a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></div>
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
                  <li class="in" name="ikoda.sparse.RDDLabeledPointInterface"><span>RDDLabeledPointInterface</span></li><li class="in" name="ikoda.sparse.RDDLabeledPointInternalOperations"><span>RDDLabeledPointInternalOperations</span></li><li class="in" name="ikoda.sparse.RDDLabeledPointDataLoader"><span>RDDLabeledPointDataLoader</span></li><li class="in" name="ikoda.sparse.RDDLabeledPointTransformations"><span>RDDLabeledPointTransformations</span></li><li class="in" name="ikoda.sparse.RDDLabeledPointParent"><span>RDDLabeledPointParent</span></li><li class="in" name="ikoda.utilobjects.SparkConfProviderWithStreaming"><span>SparkConfProviderWithStreaming</span></li><li class="in" name="ikoda.utilobjects.UtilFunctions"><span>UtilFunctions</span></li><li class="in" name="grizzled.slf4j.Logging"><span>Logging</span></li><li class="in" name="scala.Serializable"><span>Serializable</span></li><li class="in" name="java.io.Serializable"><span>Serializable</span></li><li class="in" name="scala.AnyRef"><span>AnyRef</span></li><li class="in" name="scala.Any"><span>Any</span></li>
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
        <div id="constructors" class="members">
              <h3>Instance Constructors</h3>
              <ol><li name="ikoda.sparse.RDDLabeledPointInterface#&lt;init&gt;" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="&lt;init&gt;(ilp:ikoda.sparse.LpData):ikoda.sparse.RDDLabeledPointInterface"></a>
      <a id="&lt;init&gt;:RDDLabeledPointInterface"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">new</span>
      </span>
      <span class="symbol">
        <span class="name">RDDLabeledPointInterface</span><span class="params">(<span name="ilp">ilp: <a href="LpData.html" class="extype" name="ikoda.sparse.LpData">LpData</a></span>)</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@&lt;init&gt;(ilp:ikoda.sparse.LpData):ikoda.sparse.RDDLabeledPointInterface" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li></ol>
            </div>

        <div id="types" class="types members">
              <h3>Type Members</h3>
              <ol><li name="ikoda.sparse.RDDLabeledPointParent.FTDoubleDouble_Double" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@FTDoubleDouble_Double=(Double,Double)=&gt;Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@!=(x$1:Any):Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@##():Int" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@==(x$1:Any):Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#_dividedBy" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="_dividedBy:RDDLabeledPointParent.this.FTDoubleDouble_Double"></a>
      <a id="_dividedBy:FTDoubleDouble_Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">val</span>
      </span>
      <span class="symbol">
        <span class="name">_dividedBy</span><span class="result">: <a href="#FTDoubleDouble_Double=(Double,Double)=&gt;Double" class="extmbr" name="ikoda.sparse.RDDLabeledPointInterface.FTDoubleDouble_Double">FTDoubleDouble_Double</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@_dividedBy:RDDLabeledPointParent.this.FTDoubleDouble_Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Function definition</p><div class="fullcomment"><div class="comment cmt"><p>Function definition</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#_multipliedBy" visbl="pub" data-isabs="false" fullComment="yes" group="cpt">
      <a id="_multipliedBy:RDDLabeledPointParent.this.FTDoubleDouble_Double"></a>
      <a id="_multipliedBy:FTDoubleDouble_Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">_multipliedBy</span><span class="result">: <a href="#FTDoubleDouble_Double=(Double,Double)=&gt;Double" class="extmbr" name="ikoda.sparse.RDDLabeledPointInterface.FTDoubleDouble_Double">FTDoubleDouble_Double</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@_multipliedBy:RDDLabeledPointParent.this.FTDoubleDouble_Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Function definition</p><div class="fullcomment"><div class="comment cmt"><p>Function definition</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#appname" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="appname:String"></a>
      <a id="appname:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">appname</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@appname:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@asInstanceOf[T0]:T0" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>Any</dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#breakPathToDirAndFile" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="breakPathToDirAndFile(path:String):(String,String)"></a>
      <a id="breakPathToDirAndFile(String):(String,String)"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">breakPathToDirAndFile</span><span class="params">(<span name="path">path: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: (<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Predef.String">String</span>)</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@breakPathToDirAndFile(path:String):(String,String)" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="scala.this.throws.&lt;init&gt;$default$1[Nothing]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#clearSession" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="clearSession:Unit"></a>
      <a id="clearSession:Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">clearSession</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@clearSession:Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@clone():Object" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected[<a href="../../java$lang.html" class="extype" name="java.lang">java.lang</a>] </dd><dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="classOf[java.lang.CloneNotSupportedException]">...</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnCount" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnCount:Int"></a>
      <a id="columnCount:Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnCount</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnCount:Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Number of columns in the column map.</p><div class="fullcomment"><div class="comment cmt"><p>Number of columns in the column map. This may or may not == columnsFromDataRDD.size depending
on whether data was validated when loaded and whether or not rows have been removed</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnCountFromDataRDD" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnCountFromDataRDD():Long"></a>
      <a id="columnCountFromDataRDD():Long"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnCountFromDataRDD</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Long">Long</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnCountFromDataRDD():Long" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">the actual number of columns/features with at least one active value in the dataset</p><div class="fullcomment"><div class="comment cmt"><p>the actual number of columns/features with at least one active value in the dataset</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnHeads" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnHeads():List[ikoda.sparse.ColumnHeadTuple]"></a>
      <a id="columnHeads():List[ColumnHeadTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnHeads</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.List">List</span>[<a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnHeads():List[ikoda.sparse.ColumnHeadTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Columns/features text values as List[ColumnHeadTuple]
</p><div class="fullcomment"><div class="comment cmt"><p>Columns/features text values as List[ColumnHeadTuple]
</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnHeadsAsString" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnHeadsAsString():String"></a>
      <a id="columnHeadsAsString():String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnHeadsAsString</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnHeadsAsString():String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Gets the columns/features text values as one csv String
</p><div class="fullcomment"><div class="comment cmt"><p>Gets the columns/features text values as one csv String
</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnHeadsStringList" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnHeadsStringList():List[String]"></a>
      <a id="columnHeadsStringList():List[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnHeadsStringList</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.List">List</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnHeadsStringList():List[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Gets the columns/features text values as List[String]
</p><div class="fullcomment"><div class="comment cmt"><p>Gets the columns/features text values as List[String]
</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnIndexNameMap" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnIndexNameMap():Map[Int,String]"></a>
      <a id="columnIndexNameMap():Map[Int,String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnIndexNameMap</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Int">Int</span>, <span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnIndexNameMap():Map[Int,String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Map Int -&gt; String for each column index and its text value</p><div class="fullcomment"><div class="comment cmt"><p>Map Int -&gt; String for each column index and its text value</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#columnMapAsString" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnMapAsString(offset:Int):String"></a>
      <a id="columnMapAsString(Int):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnMapAsString</span><span class="params">(<span name="offset">offset: <span class="extype" name="scala.Int">Int</span> = <span class="symbol">1</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnMapAsString(offset:Int):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns csv numericLabel,testLabel</p><div class="fullcomment"><div class="comment cmt"><p>Returns csv numericLabel,testLabel</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnMaxIndex" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnMaxIndex:Int"></a>
      <a id="columnMaxIndex:Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnMaxIndex</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnMaxIndex:Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The max index value in the column map.</p><div class="fullcomment"><div class="comment cmt"><p>The max index value in the column map. This may be higher than the actual column count if columns have been removed from the data</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#columnsFromDataRDD" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="columnsFromDataRDD():Set[Int]"></a>
      <a id="columnsFromDataRDD():Set[Int]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">columnsFromDataRDD</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.Set">Set</span>[<span class="extype" name="scala.Int">Int</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@columnsFromDataRDD():Set[Int]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A set of columns/features that represents all features that have at least one active value in the dataset</p><div class="fullcomment"><div class="comment cmt"><p>A set of columns/features that represents all features that have at least one active value in the dataset</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#convertToMLLibPackageRDD" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="convertToMLLibPackageRDD():org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint]"></a>
      <a id="convertToMLLibPackageRDD():RDD[LabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">convertToMLLibPackageRDD</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.rdd.RDD">RDD</span>[<span class="extype" name="org.apache.spark.mllib.regression.LabeledPoint">LabeledPoint</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@convertToMLLibPackageRDD():org.apache.spark.rdd.RDD[org.apache.spark.mllib.regression.LabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">*
Returns RDD[org.apache.spark.mllib.regression.LabeledPoint] for older versions of Spark machine learning</p><div class="fullcomment"><div class="comment cmt"><p>*
Returns RDD[org.apache.spark.mllib.regression.LabeledPoint] for older versions of Spark machine learning</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#copy" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="copy():ikoda.sparse.RDDLabeledPoint"></a>
      <a id="copy():RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">copy</span><span class="params">()</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@copy():ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Maps a copy of all data in current RDDLabeledPoint</p><div class="fullcomment"><div class="comment cmt"><p>Maps a copy of all data in current RDDLabeledPoint</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#copyColumnMap" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="copyColumnMap:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple]"></a>
      <a id="copyColumnMap:ListMap[Int,ColumnHeadTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">copyColumnMap</span><span class="result">: <span class="extype" name="scala.collection.mutable.ListMap">ListMap</span>[<span class="extype" name="scala.Int">Int</span>, <a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@copyColumnMap:scala.collection.mutable.ListMap[Int,ikoda.sparse.ColumnHeadTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Maps a copy of the Column  Map</p><div class="fullcomment"><div class="comment cmt"><p>Maps a copy of the Column  Map</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#copyTargetMap" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="copyTargetMap:Map[String,Double]"></a>
      <a id="copyTargetMap:Map[String,Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">copyTargetMap</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@copyTargetMap:Map[String,Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Maps a copy of the Target Map</p><div class="fullcomment"><div class="comment cmt"><p>Maps a copy of the Target Map</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#datastaxpackageversion" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="datastaxpackageversion:String"></a>
      <a id="datastaxpackageversion:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">datastaxpackageversion</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@datastaxpackageversion:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@debug(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@debug(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@debug(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#doubleDividedByDouble" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="doubleDividedByDouble(d1:Double,d2:Double):Double"></a>
      <a id="doubleDividedByDouble(Double,Double):Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">doubleDividedByDouble</span><span class="params">(<span name="d1">d1: <span class="extype" name="scala.Double">Double</span></span>, <span name="d2">d2: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Double">Double</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@doubleDividedByDouble(d1:Double,d2:Double):Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#dummyRow" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="dummyRow():Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="dummyRow():Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">dummyRow</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@dummyRow():Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@eq(x$1:AnyRef):Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@equals(x$1:Any):Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@error(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@error(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@error(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#extractDouble" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="extractDouble(expectedNumber:Any):Option[Double]"></a>
      <a id="extractDouble(Any):Option[Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">extractDouble</span><span class="params">(<span name="expectedNumber">expectedNumber: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@extractDouble(expectedNumber:Any):Option[Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#extractLong" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="extractLong(expectedNumber:Any):Option[Long]"></a>
      <a id="extractLong(Any):Option[Long]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">extractLong</span><span class="params">(<span name="expectedNumber">expectedNumber: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Long">Long</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@extractLong(expectedNumber:Any):Option[Long]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#extractString" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="extractString(expectedString:Any):Option[String]"></a>
      <a id="extractString(Any):Option[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">extractString</span><span class="params">(<span name="expectedString">expectedString: <span class="extype" name="scala.Any">Any</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@extractString(expectedString:Any):Option[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@finalize():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected[<a href="../../java$lang.html" class="extype" name="java.lang">java.lang</a>] </dd><dt>Definition Classes</dt><dd>AnyRef</dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[java.lang.Throwable]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getCellValue" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getCellValue(lp:org.apache.spark.ml.feature.LabeledPoint,colIdx:Int):Option[Double]"></a>
      <a id="getCellValue(LabeledPoint,Int):Option[Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getCellValue</span><span class="params">(<span name="lp">lp: <span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span></span>, <span name="colIdx">colIdx: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getCellValue(lp:org.apache.spark.ml.feature.LabeledPoint,colIdx:Int):Option[Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The value specified at a given index of a LabeledPoint</p><div class="fullcomment"><div class="comment cmt"><p>The value specified at a given index of a LabeledPoint</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getClass():Class[_]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getColumnIndex" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getColumnIndex(colName:String,suppressWarnings:Boolean):Int"></a>
      <a id="getColumnIndex(String,Boolean):Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getColumnIndex</span><span class="params">(<span name="colName">colName: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="suppressWarnings">suppressWarnings: <span class="extype" name="scala.Boolean">Boolean</span> = <span class="symbol">false</span></span>)</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getColumnIndex(colName:String,suppressWarnings:Boolean):Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Gets the column/feature index for a given column/feature name
Returns -1 if column not found
suppressWarnings = true to prevent logging &quot;not found&quot; column indices
</p><div class="fullcomment"><div class="comment cmt"><p>Gets the column/feature index for a given column/feature name
Returns -1 if column not found
suppressWarnings = true to prevent logging &quot;not found&quot; column indices
</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getColumnName" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getColumnName(colIndex:Int):String"></a>
      <a id="getColumnName(Int):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getColumnName</span><span class="params">(<span name="colIndex">colIndex: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getColumnName(colIndex:Int):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Gets the column/feature text value from the given numeric index</p><div class="fullcomment"><div class="comment cmt"><p>Gets the column/feature text value from the given numeric index</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getColumnNameAsOption" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getColumnNameAsOption(colIndex:Int):Option[String]"></a>
      <a id="getColumnNameAsOption(Int):Option[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getColumnNameAsOption</span><span class="params">(<span name="colIndex">colIndex: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getColumnNameAsOption(colIndex:Int):Option[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Gets the column/feature text value as Option from the given numeric index</p><div class="fullcomment"><div class="comment cmt"><p>Gets the column/feature text value as Option from the given numeric index</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#getListOfFiles" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getListOfFiles(dir:String):List[String]"></a>
      <a id="getListOfFiles(String):List[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getListOfFiles</span><span class="params">(<span name="dir">dir: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.List">List</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getListOfFiles(dir:String):List[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#getListOfSubDirectories" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getListOfSubDirectories(dir:String):List[String]"></a>
      <a id="getListOfSubDirectories(String):List[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getListOfSubDirectories</span><span class="params">(<span name="dir">dir: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.List">List</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getListOfSubDirectories(dir:String):List[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#getListOfSubDirectoriesOlderThan" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getListOfSubDirectoriesOlderThan(dir:String,age:Long):List[String]"></a>
      <a id="getListOfSubDirectoriesOlderThan(String,Long):List[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getListOfSubDirectoriesOlderThan</span><span class="params">(<span name="dir">dir: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="age">age: <span class="extype" name="scala.Long">Long</span></span>)</span><span class="result">: <span class="extype" name="scala.List">List</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getListOfSubDirectoriesOlderThan(dir:String,age:Long):List[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getName" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getName():String"></a>
      <a id="getName():String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getName</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getName():String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The user defined name of this dataset.</p><div class="fullcomment"><div class="comment cmt"><p>The user defined name of this dataset.</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getOrCreateUUID" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getOrCreateUUID(strUUID:String):java.util.UUID"></a>
      <a id="getOrCreateUUID(String):UUID"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getOrCreateUUID</span><span class="params">(<span name="strUUID">strUUID: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="java.util.UUID">UUID</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getOrCreateUUID(strUUID:String):java.util.UUID" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Creates a UUID if the given input is invalid, otherwise converts the input to UUID</p><div class="fullcomment"><div class="comment cmt"><p>Creates a UUID if the given input is invalid, otherwise converts the input to UUID</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#getOrThrow" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getOrThrow(so:scala.util.Try[ikoda.sparse.RDDLabeledPoint]):ikoda.sparse.RDDLabeledPoint"></a>
      <a id="getOrThrow(Try[RDDLabeledPoint]):RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getOrThrow</span><span class="params">(<span name="so">so: <span class="extype" name="scala.util.Try">Try</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>)</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getOrThrow(so:scala.util.Try[ikoda.sparse.RDDLabeledPoint]):ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#getOrThrow" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getOrThrow(so:Option[ikoda.sparse.RDDLabeledPoint]):ikoda.sparse.RDDLabeledPoint"></a>
      <a id="getOrThrow(Option[RDDLabeledPoint]):RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getOrThrow</span><span class="params">(<span name="so">so: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>)</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getOrThrow(so:Option[ikoda.sparse.RDDLabeledPoint]):ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getRowIdAndLabel" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getRowIdAndLabel:Seq[(String,Double)]"></a>
      <a id="getRowIdAndLabel:Seq[(String,Double)]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getRowIdAndLabel</span><span class="result">: <span class="extype" name="scala.Seq">Seq</span>[(<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>)]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getRowIdAndLabel:Seq[(String,Double)]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The row id and label for every row in the data set</p><div class="fullcomment"><div class="comment cmt"><p>The row id and label for every row in the data set</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getRowIds" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getRowIds:Seq[String]"></a>
      <a id="getRowIds:Seq[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getRowIds</span><span class="result">: <span class="extype" name="scala.Seq">Seq</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getRowIds:Seq[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The row ids for every row of the dataset</p><div class="fullcomment"><div class="comment cmt"><p>The row ids for every row of the dataset</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#getSparkSession" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getSparkSession():org.apache.spark.sql.SparkSession"></a>
      <a id="getSparkSession():SparkSession"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getSparkSession</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.sql.SparkSession">SparkSession</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getSparkSession():org.apache.spark.sql.SparkSession" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#getSparkStreamingContext" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="getSparkStreamingContext():org.apache.spark.streaming.StreamingContext"></a>
      <a id="getSparkStreamingContext():StreamingContext"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getSparkStreamingContext</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.streaming.StreamingContext">StreamingContext</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getSparkStreamingContext():org.apache.spark.streaming.StreamingContext" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getTargetId" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getTargetId(targetName:String):Option[Double]"></a>
      <a id="getTargetId(String):Option[Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getTargetId</span><span class="params">(<span name="targetName">targetName: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getTargetId(targetName:String):Option[Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns the numeric value of a label from its text value</p><div class="fullcomment"><div class="comment cmt"><p>Returns the numeric value of a label from its text value</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getTargetName" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getTargetName(targetId:Double):String"></a>
      <a id="getTargetName(Double):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getTargetName</span><span class="params">(<span name="targetId">targetId: <span class="extype" name="scala.Double">Double</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getTargetName(targetId:Double):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The name, i.e., text value, of a target specified by its numeric value</p><div class="fullcomment"><div class="comment cmt"><p>The name, i.e., text value, of a target specified by its numeric value</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[Exception]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#getTargets" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="getTargets():Map[String,Double]"></a>
      <a id="getTargets():Map[String,Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">getTargets</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@getTargets():Map[String,Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Targets as text -&gt; numeric</p><div class="fullcomment"><div class="comment cmt"><p>Targets as text -&gt; numeric</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@hashCode():Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef → Any</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#info" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="info():String"></a>
      <a id="info():String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">info</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@info():String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Returns column count, row count, target count and number of partitions</p><div class="fullcomment"><div class="comment cmt"><p>Returns column count, row count, target count and number of partitions</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@info(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@info(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@info(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#intitializeSpark" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="intitializeSpark():Unit"></a>
      <a id="intitializeSpark():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">intitializeSpark</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@intitializeSpark():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isDebugEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#isEmpty" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="isEmpty():Boolean"></a>
      <a id="isEmpty():Boolean"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">isEmpty</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Boolean">Boolean</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isEmpty():Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">True if there are no features/columns in the column map</p><div class="fullcomment"><div class="comment cmt"><p>True if there are no features/columns in the column map</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isErrorEnabled:Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isInfoEnabled:Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isInstanceOf[T0]:Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isTraceEnabled:Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@isWarnEnabled:Boolean" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#keySpaceCleanName" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="keySpaceCleanName(keySpaceName:String):Option[String]"></a>
      <a id="keySpaceCleanName(String):Option[String]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">keySpaceCleanName</span><span class="params">(<span name="keySpaceName">keySpaceName: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@keySpaceCleanName(keySpaceName:String):Option[String]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#killSparkStreamingContext" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="killSparkStreamingContext:Unit"></a>
      <a id="killSparkStreamingContext:Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">killSparkStreamingContext</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@killSparkStreamingContext:Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#localo" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="localo:scala.util.Try[Boolean]"></a>
      <a id="localo:Try[Boolean]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">localo</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<span class="extype" name="scala.Boolean">Boolean</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@localo:scala.util.Try[Boolean]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@logger:grizzled.slf4j.Logger" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@loggerName:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#lpData" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="lpData():org.apache.spark.rdd.RDD[org.apache.spark.ml.feature.LabeledPoint]"></a>
      <a id="lpData():RDD[LabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">lpData</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.rdd.RDD">RDD</span>[<span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@lpData():org.apache.spark.rdd.RDD[org.apache.spark.ml.feature.LabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The full dataset as RDD[LabeledPoint].</p><div class="fullcomment"><div class="comment cmt"><p>The full dataset as RDD[LabeledPoint]. RowIds not included</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#lpHash" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="lpHash(labeledPoint:org.apache.spark.ml.feature.LabeledPoint):Int"></a>
      <a id="lpHash(LabeledPoint):Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">lpHash</span><span class="params">(<span name="labeledPoint">labeledPoint: <span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span></span>)</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@lpHash(labeledPoint:org.apache.spark.ml.feature.LabeledPoint):Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@ne(x$1:AnyRef):Boolean" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@notify():Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@notifyAll():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#pResetCellTupleSeqColIdx" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="pResetCellTupleSeqColIdx(cellTupSeq:Seq[ikoda.sparse.CellTuple],newidx:Int,oldidx:Int):Seq[ikoda.sparse.CellTuple]"></a>
      <a id="pResetCellTupleSeqColIdx(Seq[CellTuple],Int,Int):Seq[CellTuple]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">pResetCellTupleSeqColIdx</span><span class="params">(<span name="cellTupSeq">cellTupSeq: <span class="extype" name="scala.Seq">Seq</span>[<a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>, <span name="newidx">newidx: <span class="extype" name="scala.Int">Int</span></span>, <span name="oldidx">oldidx: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Seq">Seq</span>[<a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@pResetCellTupleSeqColIdx(cellTupSeq:Seq[ikoda.sparse.CellTuple],newidx:Int,oldidx:Int):Seq[ikoda.sparse.CellTuple]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#path" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="path:String"></a>
      <a id="path:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">var</span>
      </span>
      <span class="symbol">
        <span class="name">path</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@path:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected[<a href="package.html" class="extype" name="ikoda.sparse">ikoda.sparse</a>] </dd><dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#plowerCaseColumnHeads" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="plowerCaseColumnHeads:ikoda.sparse.RDDLabeledPoint"></a>
      <a id="plowerCaseColumnHeads:RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">plowerCaseColumnHeads</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@plowerCaseColumnHeads:ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#preExistingSession" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="preExistingSession():Option[org.apache.spark.sql.SparkSession]"></a>
      <a id="preExistingSession():Option[SparkSession]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">preExistingSession</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="org.apache.spark.sql.SparkSession">SparkSession</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@preExistingSession():Option[org.apache.spark.sql.SparkSession]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#printHashMapToCsv" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="printHashMapToCsv(m:Map[String,String],name:String,path:String):Unit"></a>
      <a id="printHashMapToCsv(Map[String,String],String,String):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">printHashMapToCsv</span><span class="params">(<span name="m">m: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Predef.String">String</span>]</span>, <span name="name">name: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="path">path: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@printHashMapToCsv(m:Map[String,String],name:String,path:String):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#printLocal" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="printLocal(path:String,text:String):Unit"></a>
      <a id="printLocal(String,String):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">printLocal</span><span class="params">(<span name="path">path: <span class="extype" name="scala.Predef.String">String</span></span>, <span name="text">text: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@printLocal(path:String,text:String):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#repartition" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="repartition(partitions:Int):Unit"></a>
      <a id="repartition(Int):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">repartition</span><span class="params">(<span name="partitions">partitions: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@repartition(partitions:Int):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Repartiions the RDD data</p><div class="fullcomment"><div class="comment cmt"><p>Repartiions the RDD data</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#rowCount" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="rowCount:Long"></a>
      <a id="rowCount:Long"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">rowCount</span><span class="result">: <span class="extype" name="scala.Long">Long</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@rowCount:Long" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Precise row count</p><div class="fullcomment"><div class="comment cmt"><p>Precise row count</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#rowCountEstimate" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="rowCountEstimate:Double"></a>
      <a id="rowCountEstimate:Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">rowCountEstimate</span><span class="result">: <span class="extype" name="scala.Double">Double</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@rowCountEstimate:Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Estimated row count with 5000 millisecond window for calculation</p><div class="fullcomment"><div class="comment cmt"><p>Estimated row count with 5000 millisecond window for calculation</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#show" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="show(rows:Int):String"></a>
      <a id="show(Int):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">show</span><span class="params">(<span name="rows">rows: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@show(rows:Int):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The top n rows as a String</p><div class="fullcomment"><div class="comment cmt"><p>The top n rows as a String</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#showMemoryUsage" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="showMemoryUsage(name:String):Unit"></a>
      <a id="showMemoryUsage(String):Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">showMemoryUsage</span><span class="params">(<span name="name">name: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@showMemoryUsage(name:String):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#showMemoryUsage" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="showMemoryUsage:Unit"></a>
      <a id="showMemoryUsage:Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">showMemoryUsage</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@showMemoryUsage:Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#spark" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="spark():org.apache.spark.sql.SparkSession"></a>
      <a id="spark():SparkSession"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">spark</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.sql.SparkSession">SparkSession</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@spark():org.apache.spark.sql.SparkSession" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkcassandraconnectionhost" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkcassandraconnectionhost:String"></a>
      <a id="sparkcassandraconnectionhost:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkcassandraconnectionhost</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkcassandraconnectionhost:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkcoresmax" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkcoresmax:String"></a>
      <a id="sparkcoresmax:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkcoresmax</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkcoresmax:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkdriverbindAddress" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkdriverbindAddress:String"></a>
      <a id="sparkdriverbindAddress:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkdriverbindAddress</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkdriverbindAddress:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkdrivermaxResultSize" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkdrivermaxResultSize:String"></a>
      <a id="sparkdrivermaxResultSize:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkdrivermaxResultSize</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkdrivermaxResultSize:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkdrivermemory" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkdrivermemory:String"></a>
      <a id="sparkdrivermemory:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkdrivermemory</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkdrivermemory:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkexecutormemory" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkexecutormemory:String"></a>
      <a id="sparkexecutormemory:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkexecutormemory</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkexecutormemory:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparkmaster" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparkmaster:String"></a>
      <a id="sparkmaster:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparkmaster</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparkmaster:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#sparknetworktimeout" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sparknetworktimeout:String"></a>
      <a id="sparknetworktimeout:String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">sparknetworktimeout</span><span class="result">: <span class="extype" name="java.lang.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparknetworktimeout:String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#sparseData" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="sparseData():org.apache.spark.rdd.RDD[(org.apache.spark.ml.feature.LabeledPoint,Int,String)]"></a>
      <a id="sparseData():RDD[(LabeledPoint,Int,String)]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">sparseData</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.rdd.RDD">RDD</span>[(<span class="extype" name="org.apache.spark.ml.feature.LabeledPoint">LabeledPoint</span>, <span class="extype" name="scala.Int">Int</span>, <span class="extype" name="scala.Predef.String">String</span>)]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sparseData():org.apache.spark.rdd.RDD[(org.apache.spark.ml.feature.LabeledPoint,Int,String)]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The full dataset along with each rowId and hashcode</p><div class="fullcomment"><div class="comment cmt"><p>The full dataset along with each rowId and hashcode</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#stackTraceString" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="stackTraceString(e:Throwable):String"></a>
      <a id="stackTraceString(Throwable):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">stackTraceString</span><span class="params">(<span name="e">e: <span class="extype" name="scala.Throwable">Throwable</span></span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@stackTraceString(e:Throwable):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.SparkConfProviderWithStreaming#streamingo" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="streamingo:scala.util.Try[Boolean]"></a>
      <a id="streamingo:Try[Boolean]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">lazy val</span>
      </span>
      <span class="symbol">
        <span class="name">streamingo</span><span class="result">: <span class="extype" name="scala.util.Try">Try</span>[<span class="extype" name="scala.Boolean">Boolean</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@streamingo:scala.util.Try[Boolean]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#stripDecimalPlace" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="stripDecimalPlace(s:Option[String]):String"></a>
      <a id="stripDecimalPlace(Option[String]):String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">stripDecimalPlace</span><span class="params">(<span name="s">s: <span class="extype" name="scala.Option">Option</span>[<span class="extype" name="scala.Predef.String">String</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@stripDecimalPlace(s:Option[String]):String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
    </li><li name="ikoda.utilobjects.UtilFunctions#sum" visbl="prt" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="sum[T](x:List[T])(implicitevidence$1:Numeric[T]):T"></a>
      <a id="sum[T](List[T])(Numeric[T]):T"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">sum</span><span class="tparams">[<span name="T">T</span>]</span><span class="params">(<span name="x">x: <span class="extype" name="scala.List">List</span>[<span class="extype" name="ikoda.utilobjects.UtilFunctions.sum.T">T</span>]</span>)</span><span class="params">(<span class="implicit">implicit </span><span name="arg0">arg0: <span class="extype" name="scala.Numeric">Numeric</span>[<span class="extype" name="ikoda.utilobjects.UtilFunctions.sum.T">T</span>]</span>)</span><span class="result">: <span class="extype" name="ikoda.utilobjects.UtilFunctions.sum.T">T</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@sum[T](x:List[T])(implicitevidence$1:Numeric[T]):T" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd><a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@synchronized[T0](x$1:=&gt;T0):T0" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd>AnyRef</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#targetCount" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="targetCount():Int"></a>
      <a id="targetCount():Int"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">targetCount</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Int">Int</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@targetCount():Int" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The number of distinct targets/labels in the data set</p><div class="fullcomment"><div class="comment cmt"><p>The number of distinct targets/labels in the data set</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations#targetMapAsString" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="targetMapAsString():String"></a>
      <a id="targetMapAsString():String"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">targetMapAsString</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Predef.String">String</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@targetMapAsString():String" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">A csv format String textValue/numericValue</p><div class="fullcomment"><div class="comment cmt"><p>A csv format String textValue/numericValue</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointParent#targetMaxValue" visbl="pub" data-isabs="false" fullComment="yes" group="dp">
      <a id="targetMaxValue:Double"></a>
      <a id="targetMaxValue:Double"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">targetMaxValue</span><span class="result">: <span class="extype" name="scala.Double">Double</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@targetMaxValue:Double" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">The max numeric value of the targets</p><div class="fullcomment"><div class="comment cmt"><p>The max numeric value of the targets</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@toString():String" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@trace(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@trace(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@trace(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations#transformLabelToThisSchema" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="transformLabelToThisSchema(sparseToConvert:ikoda.sparse.RDDLabeledPoint,newTargetMap:scala.collection.mutable.HashMap[String,Double]):Map[Double,Double]"></a>
      <a id="transformLabelToThisSchema(RDDLabeledPoint,HashMap[String,Double]):Map[Double,Double]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">transformLabelToThisSchema</span><span class="params">(<span name="sparseToConvert">sparseToConvert: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>, <span name="newTargetMap">newTargetMap: <span class="extype" name="scala.collection.mutable.HashMap">HashMap</span>[<span class="extype" name="scala.Predef.String">String</span>, <span class="extype" name="scala.Double">Double</span>]</span>)</span><span class="result">: <span class="extype" name="scala.Predef.Map">Map</span>[<span class="extype" name="scala.Double">Double</span>, <span class="extype" name="scala.Double">Double</span>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@transformLabelToThisSchema(sparseToConvert:ikoda.sparse.RDDLabeledPoint,newTargetMap:scala.collection.mutable.HashMap[String,Double]):Map[Double,Double]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Matches the label numeric values in sparseToConvert with the labels in this RDDLabeledPoint</p><div class="fullcomment"><div class="comment cmt"><p>Matches the label numeric values in sparseToConvert with the labels in this RDDLabeledPoint</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations#transformLibSvmProcessorToRDDLabeledPoint" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="transformLibSvmProcessorToRDDLabeledPoint(spark:org.apache.spark.sql.SparkSession,libsvmProcessor:ikoda.utils.LibSvmProcessor):ikoda.sparse.RDDLabeledPoint"></a>
      <a id="transformLibSvmProcessorToRDDLabeledPoint(SparkSession,LibSvmProcessor):RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">transformLibSvmProcessorToRDDLabeledPoint</span><span class="params">(<span name="spark">spark: <span class="extype" name="org.apache.spark.sql.SparkSession">SparkSession</span></span>, <span name="libsvmProcessor">libsvmProcessor: <span class="extype" name="ikoda.utils.LibSvmProcessor">LibSvmProcessor</span></span>)</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@transformLibSvmProcessorToRDDLabeledPoint(spark:org.apache.spark.sql.SparkSession,libsvmProcessor:ikoda.utils.LibSvmProcessor):ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint</p><div class="fullcomment"><div class="comment cmt"><p>Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations#transformRDDToDataFrame" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="transformRDDToDataFrame():org.apache.spark.sql.DataFrame"></a>
      <a id="transformRDDToDataFrame():DataFrame"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">transformRDDToDataFrame</span><span class="params">()</span><span class="result">: <span class="extype" name="org.apache.spark.sql.DataFrame">DataFrame</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@transformRDDToDataFrame():org.apache.spark.sql.DataFrame" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p><div class="fullcomment"><div class="comment cmt"></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations#transformToRDDLabeledPointWithSchemaMatchingThis" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="transformToRDDLabeledPointWithSchemaMatchingThis(sparseToConvert:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]"></a>
      <a id="transformToRDDLabeledPointWithSchemaMatchingThis(RDDLabeledPoint):Option[RDDLabeledPoint]"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">transformToRDDLabeledPointWithSchemaMatchingThis</span><span class="params">(<span name="sparseToConvert">sparseToConvert: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>)</span><span class="result">: <span class="extype" name="scala.Option">Option</span>[<a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a>]</span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@transformToRDDLabeledPointWithSchemaMatchingThis(sparseToConvert:ikoda.sparse.RDDLabeledPoint):Option[ikoda.sparse.RDDLabeledPoint]" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Converts sparseToConvert so that column and label indices match this</p><div class="fullcomment"><div class="comment cmt"><p>Converts sparseToConvert so that column and label indices match this</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations#transformToRDDLabeledPointWithSchemaMatchingThis" visbl="pub" data-isabs="false" fullComment="yes" group="man">
      <a id="transformToRDDLabeledPointWithSchemaMatchingThis(libsvmProcessor:ikoda.utils.LibSvmProcessor):ikoda.sparse.RDDLabeledPoint"></a>
      <a id="transformToRDDLabeledPointWithSchemaMatchingThis(LibSvmProcessor):RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">transformToRDDLabeledPointWithSchemaMatchingThis</span><span class="params">(<span name="libsvmProcessor">libsvmProcessor: <span class="extype" name="ikoda.utils.LibSvmProcessor">LibSvmProcessor</span></span>)</span><span class="result">: <a href="RDDLabeledPoint.html" class="extype" name="ikoda.sparse.RDDLabeledPoint">RDDLabeledPoint</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@transformToRDDLabeledPointWithSchemaMatchingThis(libsvmProcessor:ikoda.utils.LibSvmProcessor):ikoda.sparse.RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt">Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint while mainatining the row indices and label indices of this RDDLabeledPoint</p><div class="fullcomment"><div class="comment cmt"><p>Converts from ikoda.utils.CsvSpreadheet to RDDLabeledPoint while mainatining the row indices and label indices of this RDDLabeledPoint</p></div><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="symbol">classOf[IKodaMLException]</span>
    </span>)</span>
              
        </dd><dt>Exceptions thrown</dt><dd><span class="cmt"></span></dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointDataLoader#validateColumnCount" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="validateColumnCount():Unit"></a>
      <a id="validateColumnCount():Unit"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">def</span>
      </span>
      <span class="symbol">
        <span class="name">validateColumnCount</span><span class="params">()</span><span class="result">: <span class="extype" name="scala.Unit">Unit</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@validateColumnCount():Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Definition Classes</dt><dd><a href="RDDLabeledPointDataLoader.html" class="extype" name="ikoda.sparse.RDDLabeledPointDataLoader">RDDLabeledPointDataLoader</a></dd><dt>Annotations</dt><dd>
                <span class="name">@throws</span><span class="args">(<span>
      
      <span class="defval" name="scala.this.throws.&lt;init&gt;$default$1[Nothing]">...</span>
    </span>)</span>
              
        </dd></dl></div>
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@wait():Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@wait(x$1:Long,x$2:Int):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@wait(x$1:Long):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@warn(mkr:org.slf4j.Marker,msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@warn(msg:=&gt;Any,t:=&gt;Throwable):Unit" title="Permalink" target="_top">
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
      <a href="../../index.html#ikoda.sparse.RDDLabeledPointInterface@warn(msg:=&gt;Any):Unit" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Attributes</dt><dd>protected </dd><dt>Definition Classes</dt><dd>Logging</dd></dl></div>
    </li></ol>
            </div>

        

        
        </div>

        <div id="inheritedMembers">
        <div class="parent" name="ikoda.sparse.RDDLabeledPointInternalOperations">
              <h3>Inherited from <a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a></h3>
            </div><div class="parent" name="ikoda.sparse.RDDLabeledPointDataLoader">
              <h3>Inherited from <a href="RDDLabeledPointDataLoader.html" class="extype" name="ikoda.sparse.RDDLabeledPointDataLoader">RDDLabeledPointDataLoader</a></h3>
            </div><div class="parent" name="ikoda.sparse.RDDLabeledPointTransformations">
              <h3>Inherited from <a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></h3>
            </div><div class="parent" name="ikoda.sparse.RDDLabeledPointParent">
              <h3>Inherited from <a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></h3>
            </div><div class="parent" name="ikoda.utilobjects.SparkConfProviderWithStreaming">
              <h3>Inherited from <a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></h3>
            </div><div class="parent" name="ikoda.utilobjects.UtilFunctions">
              <h3>Inherited from <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></h3>
            </div><div class="parent" name="grizzled.slf4j.Logging">
              <h3>Inherited from <span class="extype" name="grizzled.slf4j.Logging">Logging</span></h3>
            </div><div class="parent" name="scala.Serializable">
              <h3>Inherited from <span class="extype" name="scala.Serializable">Serializable</span></h3>
            </div><div class="parent" name="java.io.Serializable">
              <h3>Inherited from <span class="extype" name="java.io.Serializable">Serializable</span></h3>
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
