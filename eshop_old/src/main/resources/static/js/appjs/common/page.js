function pageLoad(func)
{
   	    if(pageinfo!=undefined && pageinfo!=null &&  pageinfo!='')
   	    {
   	    	var total = pageinfo.total;
   	    	var limit = pageinfo.limit;
   	    	var curPage = pageinfo.curPage;
   	    	var sumPage = Math.ceil(total/limit);
   	    	//总页数大于1
   	    	if(sumPage>=1)
   	    	{
   	    	    var parentdiv = $('#pageDiv');
		   	    var childdiv=$('<div style="text-align: right;"></div>');        //创建一个子div
		   	 
			    childdiv.addClass('am-avg-sm-2');    //添加css样式
			    childdiv.appendTo(parentdiv);        //将子div添加到父div中
			    
			    
			    
			    var childul=$('<ul style="display: inline-block;width: 50%;text-align: right;"></ul>');  
			    childul.addClass('am-pagination tpl-pagination');    
			    childul.appendTo(childdiv); 
			    
			    var childselect = $("<select style='display: inline-block;width: 7%;margin-left: 2%;' id='selpage'><option value='10'>10</option><option value='20'>20</option><option value='30'>30</option><option value='40'>40</option><option value='50'>50</option></select>");
			    childselect.attr("onchange","selectPageNum(this,'"+func+"');");
			    
			    childselect.appendTo(childdiv);
			    childselect.val(pageinfo.limit);
			    
			    var minPage =1;
			    var maxPage=5;
			    if(sumPage<=5)
			    {
			    	maxPage=sumPage;
			    }
			    else if(sumPage>5)
			    {
			    	//左边页码变
			    	if(curPage>3)
			    	{
			    		minPage=curPage-2;
			    		maxPage=curPage+2;
			    	}	
			    }
			    if(maxPage>sumPage)
			    {
			    	maxPage=sumPage;
			    }
			    
			  //首页
			    var childliSou=$('<li></li>'); 
		    	childliSou.appendTo(childul);
		    	var childaSou=$('<a>««</a>'); 
		    	childaSou.attr('href','javascript:void(0)');
		    	childaSou.attr('title','首页');
		    	if(curPage>1)
		    	{
		    		childaSou.attr("onclick","goPage(1,'"+func+"');");
		    	}
		    	childaSou.appendTo(childliSou);
			    
			    //上一页
		    	var childli=$('<li></li>'); 
		    	childli.appendTo(childul);
		    	var childa=$('<a>«</a>'); 
		    	childa.attr('href','javascript:void(0)');
		    	childa.attr('title','上一页');
		    	if(curPage>1)
		    	{
		    		childa.attr("onclick","goPage("+(curPage-1)+",'"+func+"');");
		    	}
		    	childa.appendTo(childli);
		    	
		    	//中间页
		    	for(var i=minPage;i<=maxPage;i++)
		    	{
		    		var childLiTemp=$('<li></li>'); 
		    		if(i==curPage)
			    	{
		    			childLiTemp.addClass('am-active'); 
			    	}
		    		childLiTemp.appendTo(childul);
			    	
			    	var childATemp=$('<a>'+i+'</a>'); 
			    	childATemp.attr('href','javascript:void(0)');
			    	childATemp.attr("onclick","goPage("+i+",'"+func+"');");
			    	childATemp.appendTo(childLiTemp);
		    	}
		    	
		    	//下一页
		    	var childliEnd=$('<li></li>'); 
		    	childliEnd.appendTo(childul);
		    	var childaEnd=$('<a>»</a>'); 
		    	childaEnd.attr('href','javascript:void(0)');
		    	childaEnd.attr('title','下一页');
		    	if(curPage!=sumPage)
		    	{
		    	  childaEnd.attr("onclick","goPage("+(curPage+1)+",'"+func+"');");
		    	}
		    	childaEnd.appendTo(childliEnd);
		    	
		    	//末页
		    	var childliEndEnd=$('<li></li>'); 
		    	childliEndEnd.appendTo(childul);
		    	var childaEndEnd=$('<a>»»</a>'); 
		    	childaEndEnd.attr('href','javascript:void(0)');
		    	childaEndEnd.attr('title','末页');
		    	if(curPage!=sumPage)
		    	{
		    	  childaEndEnd.attr("onclick","goPage("+sumPage+",'"+func+"');");
		    	}
		    	childaEndEnd.appendTo(childliEndEnd);
		    	
		    	
			    	
			    
			}
   	    	else
   	    	{
   	    		//初始化
   	    	    pageinfo.curPage=1;
   	    	    pageinfo.offset=0;
   	    	}
	    }       
}

//跳转到哪一页
function goPage(page,func)
{
	//给当前页赋值
	pageinfo.curPage = page;
	//起始行
	var offset = (parseInt(page)-1)*parseInt(pageinfo.limit);
	pageinfo.offset = offset;
	if(func!=undefined && func!='' && typeof(eval(func)) == "function")
	{
		eval(func+'()'); 
	}
	
}

//分页对象初始化
function pageInit()
{
	if(pageinfo!=undefined && pageinfo!=null &&  pageinfo!='')
	{
		//初始化
   	    pageinfo.curPage=1;
   	    pageinfo.offset=0;
   	    pageinfo.limit=10;
	}
}

function selectPageNum(obj,func)
{
	pageinfo.curPage=1;
	pageinfo.offset=0;
	pageinfo.limit = obj.value;
	if(func!=undefined && func!='' && typeof(eval(func)) == "function")
	{
		eval(func+'()'); 
	}
}