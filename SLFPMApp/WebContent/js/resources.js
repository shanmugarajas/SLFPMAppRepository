function go(url)
{
	window.location = url;
}

function newResource()
{
	window.location = "saveResource.do";
}

function newAllocation()
{
	window.location = "saveAllocation.do";
}

function newTrack()
{
	window.location = "saveTrack.do";
}

function deleteResource(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

function deleteAllocation(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}

function deleteTrack(url)
{
	var isOK = confirm("Are you sure to delete?");
	if(isOK)
	{
		go(url);
	}
}