<%@include file="header.jsp" %>
    
<div class="row">
  <div class="col-sm-12 col-md-12 col-lg-12">
    <div class="panel panel-default">
      <div class="panel-body">
        <div class="row">
          <div class="col-sm-6 col-md-2 col-lg-1">
            <span>Search</span>
          </div>
          <div class="col-sm-6 col-md-4 col-lg-3 pull-left">
            <input type="string" ng-model="searchString" name="searchString"/>
          </div>
        </div>
      </div>
    </div>
    <table class="table table-bordered table-striped">
      <thead>
      <tr>
        <th class="col-sm-3 col-md-6 col-lg-6">Topic</th>
        <th class="col-sm-3 col-md-2 col-lg-1">Replies</th>
        <th class="col-sm-3 col-md-2 col-lg-1">Views</th>
        <th class="col-sm-3 col-md-2 col-lg-4">Last Post</th>
      </tr>
      </thead>
      
  </div>
</div>

<%@include file="footer.jsp" %>
