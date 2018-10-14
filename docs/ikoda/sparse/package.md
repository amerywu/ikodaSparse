<!DOCTYPE html >
<html>
        <head>
          <title>sparse - ikodaSparse 1.0.0 API - ikoda.sparse</title>
          <meta name="description" content="sparse - ikodaSparse 1.0.0 API - ikoda.sparse" />
          <meta name="keywords" content="sparse ikodaSparse 1.0.0 API ikoda.sparse" />
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
            var hash = 'ikoda.sparse.package';
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
        <img alt="Package" src="../../lib/package_big.png" />
        <p id="owner"><a href="../package.html" class="extype" name="ikoda">ikoda</a></p>
        <h1>sparse</h1><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      </div>

      <h4 id="signature" class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">package</span>
      </span>
      <span class="symbol">
        <span class="name">sparse</span>
      </span>
      </h4>
      
          <div id="comment" class="fullcommenttop"></div>
        

      <div id="mbrsel">
        <div id="textfilter"><span class="pre"></span><span class="input"><input id="mbrsel-input" type="text" accesskey="/" /></span><span class="post"></span></div>
        
        
        <div id="visbl">
            <span class="filtertype">Visibility</span>
            <ol><li class="public in"><span>Public</span></li><li class="all out"><span>All</span></li></ol>
          </div>
      </div>

      <div id="template">
        <div id="allMembers">
        

        <div id="types" class="types members">
              <h3>Type Members</h3>
              <ol><li name="ikoda.sparse.CellTuple" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="CellTupleextendsOrdered[ikoda.sparse.CellTuple]withLoggingwithProductwithSerializable"></a>
      <a id="CellTuple:CellTuple"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">case class</span>
      </span>
      <span class="symbol">
        <a href="CellTuple.html"><span class="name">CellTuple</span></a><span class="params">(<span name="colIndex">colIndex: <span class="extype" name="scala.Int">Int</span></span>, <span name="label">label: <span class="extype" name="scala.Double">Double</span></span>, <span name="value">value: <span class="extype" name="scala.Double">Double</span></span>, <span name="rowId">rowId: <span class="extype" name="java.util.UUID">UUID</span></span>, <span name="rowPos">rowPos: <span class="extype" name="scala.Int">Int</span></span>)</span><span class="result"> extends <span class="extype" name="scala.Ordered">Ordered</span>[<a href="CellTuple.html" class="extype" name="ikoda.sparse.CellTuple">CellTuple</a>] with <span class="extype" name="grizzled.slf4j.Logging">Logging</span> with <span class="extype" name="scala.Product">Product</span> with <span class="extype" name="scala.Serializable">Serializable</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@CellTupleextendsOrdered[ikoda.sparse.CellTuple]withLoggingwithProductwithSerializable" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li><li name="ikoda.sparse.ColumnHeadTuple" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="ColumnHeadTupleextendsOrdered[ikoda.sparse.ColumnHeadTuple]withProductwithSerializable"></a>
      <a id="ColumnHeadTuple:ColumnHeadTuple"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">case class</span>
      </span>
      <span class="symbol">
        <a href="ColumnHeadTuple.html"><span class="name">ColumnHeadTuple</span></a><span class="params">(<span name="numericLabel">numericLabel: <span class="extype" name="scala.Int">Int</span></span>, <span name="stringLabel">stringLabel: <span class="extype" name="scala.Predef.String">String</span></span>)</span><span class="result"> extends <span class="extype" name="scala.Ordered">Ordered</span>[<a href="ColumnHeadTuple.html" class="extype" name="ikoda.sparse.ColumnHeadTuple">ColumnHeadTuple</a>] with <span class="extype" name="scala.Product">Product</span> with <span class="extype" name="scala.Serializable">Serializable</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@ColumnHeadTupleextendsOrdered[ikoda.sparse.ColumnHeadTuple]withProductwithSerializable" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li><li name="ikoda.sparse.LpData" visbl="pub" data-isabs="false" fullComment="yes" group="Ungrouped">
      <a id="LpDataextendsSerializable"></a>
      <a id="LpData:LpData"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="LpData.html"><span class="name">LpData</span></a><span class="result"> extends <span class="extype" name="scala.Serializable">Serializable</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@LpDataextendsSerializable" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <div class="fullcomment"><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@SerialVersionUID</span><span class="args">()</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPoint" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPointextendsRDDLabeledPointInterface"></a>
      <a id="RDDLabeledPoint:RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPoint.html"><span class="name">RDDLabeledPoint</span></a><span class="result"> extends <a href="RDDLabeledPointInterface.html" class="extype" name="ikoda.sparse.RDDLabeledPointInterface">RDDLabeledPointInterface</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointextendsRDDLabeledPointInterface" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p>
    </li><li name="ikoda.sparse.RDDLabeledPointDataLoader" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPointDataLoaderextendsRDDLabeledPointTransformations"></a>
      <a id="RDDLabeledPointDataLoader:RDDLabeledPointDataLoader"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPointDataLoader.html"><span class="name">RDDLabeledPointDataLoader</span></a><span class="result"> extends <a href="RDDLabeledPointTransformations.html" class="extype" name="ikoda.sparse.RDDLabeledPointTransformations">RDDLabeledPointTransformations</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointDataLoaderextendsRDDLabeledPointTransformations" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p>
    </li><li name="ikoda.sparse.RDDLabeledPointInterface" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPointInterfaceextendsRDDLabeledPointInternalOperationswithUtilFunctions"></a>
      <a id="RDDLabeledPointInterface:RDDLabeledPointInterface"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPointInterface.html"><span class="name">RDDLabeledPointInterface</span></a><span class="result"> extends <a href="RDDLabeledPointInternalOperations.html" class="extype" name="ikoda.sparse.RDDLabeledPointInternalOperations">RDDLabeledPointInternalOperations</a> with <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointInterfaceextendsRDDLabeledPointInternalOperationswithUtilFunctions" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li><li name="ikoda.sparse.RDDLabeledPointInternalOperations" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPointInternalOperationsextendsRDDLabeledPointDataLoaderwithUtilFunctions"></a>
      <a id="RDDLabeledPointInternalOperations:RDDLabeledPointInternalOperations"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPointInternalOperations.html"><span class="name">RDDLabeledPointInternalOperations</span></a><span class="result"> extends <a href="RDDLabeledPointDataLoader.html" class="extype" name="ikoda.sparse.RDDLabeledPointDataLoader">RDDLabeledPointDataLoader</a> with <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointInternalOperationsextendsRDDLabeledPointDataLoaderwithUtilFunctions" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      
    </li><li name="ikoda.sparse.RDDLabeledPointParent" visbl="pub" data-isabs="true" fullComment="yes" group="Ungrouped">
      <a id="RDDLabeledPointParentextendsSerializablewithUtilFunctionswithSparkConfProviderWithStreaming"></a>
      <a id="RDDLabeledPointParent:RDDLabeledPointParent"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier">abstract </span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPointParent.html"><span class="name">RDDLabeledPointParent</span></a><span class="result"> extends <span class="extype" name="scala.Serializable">Serializable</span> with <a href="../utilobjects/UtilFunctions.html" class="extype" name="ikoda.utilobjects.UtilFunctions">UtilFunctions</a> with <a href="../utilobjects/SparkConfProviderWithStreaming.html" class="extype" name="ikoda.utilobjects.SparkConfProviderWithStreaming">SparkConfProviderWithStreaming</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointParentextendsSerializablewithUtilFunctionswithSparkConfProviderWithStreaming" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p><div class="fullcomment"><div class="comment cmt"></div><dl class="attributes block"> <dt>Annotations</dt><dd>
                <span class="name">@SerialVersionUID</span><span class="args">()</span>
              
        </dd></dl></div>
    </li><li name="ikoda.sparse.RDDLabeledPointTransformations" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPointTransformationsextendsRDDLabeledPointParent"></a>
      <a id="RDDLabeledPointTransformations:RDDLabeledPointTransformations"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">class</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPointTransformations.html"><span class="name">RDDLabeledPointTransformations</span></a><span class="result"> extends <a href="RDDLabeledPointParent.html" class="extype" name="ikoda.sparse.RDDLabeledPointParent">RDDLabeledPointParent</a></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPointTransformationsextendsRDDLabeledPointParent" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p>
    </li></ol>
            </div>

        

        <div id="values" class="values members">
              <h3>Value Members</h3>
              <ol><li name="ikoda.sparse.RDDLabeledPoint" visbl="pub" data-isabs="false" fullComment="no" group="Ungrouped">
      <a id="RDDLabeledPoint"></a>
      <a id="RDDLabeledPoint:RDDLabeledPoint"></a>
      <h4 class="signature">
      <span class="modifier_kind">
        <span class="modifier"></span>
        <span class="kind">object</span>
      </span>
      <span class="symbol">
        <a href="RDDLabeledPoint$.html"><span class="name">RDDLabeledPoint</span></a><span class="result"> extends <span class="extype" name="grizzled.slf4j.Logging">Logging</span> with <span class="extype" name="scala.Serializable">Serializable</span></span>
      </span>
      </h4><span class="permalink">
      <a href="../../index.html#ikoda.sparse.package@RDDLabeledPoint" title="Permalink" target="_top">
        <img src="../../lib/permalink.png" alt="Permalink" />
      </a>
    </span>
      <p class="shortcomment cmt"></p>
    </li></ol>
            </div>

        

        
        </div>

        <div id="inheritedMembers">
        
        
        </div>

        <div id="groupedMembers">
        <div class="group" name="Ungrouped">
              <h3>Ungrouped</h3>
              
            </div>
        </div>

      </div>

      <div id="tooltip"></div>

      <div id="footer">  </div>


    </body>
      </html>
