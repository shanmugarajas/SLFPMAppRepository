function go(url)
{
	window.location = url;
}

function newResource()
{
	window.location = "saveResource.do";
}

function deleteResource(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}
