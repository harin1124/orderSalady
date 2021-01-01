function gfn_httpGet(url, data, config){
	let newUrl=url;
	let newConfig=config||{};
	newConfig.params=data;
	return axios.get(newUrl, newConfig).finally(()=>{});
}

function gfn_httpPost(url, data, config){
	let newUrl=url;
	let newData=JSON.stringify(data);
	let newConfig=config || {};
	newConfig.headers={"content-type":"application/json"};
	return axios.post(newUrl, newData, newConfig).finally(()=>{});
}

function gfn_httpPut(url, data, config){
	let newUrl=url;
	let newData=JSON.stringify(data);
	let newConfig=config || {};
	newConfig.headers={"content-type":"application/json"};
	return axios.put(newUrl, newData, newConfig).finally(()=>{});
}

function gfn_httpDelete(url, data, config){
	let newUrl=url;
	let newData=JSON.stringify(data);
	let newConfig=config || {};
	newConfig.headers={"content-type":"application/json"};
	return axios.delete(newUrl, newData, newConfig).finally(()=>{});
}

function gfn_httpOk(data){
	return (data.code===Constant.ResponseCode.OK);
}