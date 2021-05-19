let api = [];
api.push({
    alias: 'ClockinController',
    order: '1',
    link: '每日打卡相关接口',
    desc: '每日打卡相关接口',
    list: []
})
api[0].list.push({
    order: '1',
    desc: '根据实践 ID 获取每日打卡列表',
});
api[0].list.push({
    order: '2',
    desc: '获取具体某一天的打卡记录',
});
api[0].list.push({
    order: '3',
    desc: '添加新的一天打卡',
});
api.push({
    alias: 'PracticeController',
    order: '2',
    link: '实践相关接口',
    desc: '实践相关接口',
    list: []
})
api[1].list.push({
    order: '1',
    desc: '添加用户实践信息',
});
api.push({
    alias: 'RouteController',
    order: '3',
    link: '路线（攻略）相关接口',
    desc: '路线（攻略）相关接口',
    list: []
})
api[2].list.push({
    order: '1',
    desc: '根据分类查询路线结果按热度降序排序',
});
api[2].list.push({
    order: '2',
    desc: '获取路线详情',
});
api[2].list.push({
    order: '3',
    desc: '将该路线加入到用户计划',
});
api[2].list.push({
    order: '4',
    desc: '将该路线加入到用户收藏',
});
api[2].list.push({
    order: '5',
    desc: '添加路线仅供内部人员使用',
});
api.push({
    alias: 'TestController',
    order: '4',
    link: '测试部署（前端忽略该接口）',
    desc: '测试部署（前端忽略该接口）',
    list: []
})
api[3].list.push({
    order: '1',
    desc: 'Test connection',
});
api.push({
    alias: 'UserController',
    order: '5',
    link: '用户相关接口',
    desc: '用户相关接口',
    list: []
})
api[4].list.push({
    order: '1',
    desc: '微信小程序登录',
});
api[4].list.push({
    order: '2',
    desc: '获取用户所有计划',
});
api[4].list.push({
    order: '3',
    desc: '获取用户所有收藏路线',
});
api[4].list.push({
    order: '4',
    desc: '获取用户实践记录',
});
api[4].list.push({
    order: '5',
    desc: '该路线从用户收藏中移除',
});
api[4].list.push({
    order: '6',
    desc: '取消收藏该路线',
});
api.push({
    alias: 'error',
    order: '6',
    link: 'error_code_list',
    desc: '错误码列表',
    list: []
})
api.push({
    alias: 'dict',
    order: '7',
    link: 'dict_list',
    desc: '数据字典',
    list: []
})
document.onkeydown = keyDownSearch;
function keyDownSearch(e) {
    const theEvent = e;
    const code = theEvent.keyCode || theEvent.which || theEvent.charCode;
    if (code == 13) {
        const search = document.getElementById('search');
        const searchValue = search.value;
        let searchArr = [];
        for (let i = 0; i < api.length; i++) {
            let apiData = api[i];
            const desc = apiData.desc;
            if (desc.indexOf(searchValue) > -1) {
                searchArr.push({
                    order: apiData.order,
                    desc: apiData.desc,
                    link: apiData.link,
                    list: apiData.list
                });
            } else {
                let methodList = apiData.list || [];
                let methodListTemp = [];
                for (let j = 0; j < methodList.length; j++) {
                    const methodData = methodList[j];
                    const methodDesc = methodData.desc;
                    if (methodDesc.indexOf(searchValue) > -1) {
                        methodListTemp.push(methodData);
                        break;
                    }
                }
                if (methodListTemp.length > 0) {
                    const data = {
                        order: apiData.order,
                        desc: apiData.desc,
                        link: apiData.link,
                        list: methodListTemp
                    };
                    searchArr.push(data);
                }
            }
        }
        let html;
        if (searchValue == '') {
            const liClass = "";
            const display = "display: none";
            html = buildAccordion(api,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        } else {
            const liClass = "open";
            const display = "display: block";
            html = buildAccordion(searchArr,liClass,display);
            document.getElementById('accordion').innerHTML = html;
        }
        const Accordion = function (el, multiple) {
            this.el = el || {};
            this.multiple = multiple || false;
            const links = this.el.find('.dd');
            links.on('click', {el: this.el, multiple: this.multiple}, this.dropdown);
        };
        Accordion.prototype.dropdown = function (e) {
            const $el = e.data.el;
            $this = $(this), $next = $this.next();
            $next.slideToggle();
            $this.parent().toggleClass('open');
            if (!e.data.multiple) {
                $el.find('.submenu').not($next).slideUp("20").parent().removeClass('open');
            }
        };
        new Accordion($('#accordion'), false);
    }
}

function buildAccordion(apiData, liClass, display) {
    let html = "";
    let doc;
    if (apiData.length > 0) {
        for (let j = 0; j < apiData.length; j++) {
            html += '<li class="'+liClass+'">';
            html += '<a class="dd" href="#_' + apiData[j].link + '">' + apiData[j].order + '.&nbsp;' + apiData[j].desc + '</a>';
            html += '<ul class="sectlevel2" style="'+display+'">';
            doc = apiData[j].list;
            for (let m = 0; m < doc.length; m++) {
                html += '<li><a href="#_' + apiData[j].order + '_' + doc[m].order + '_' + doc[m].desc + '">' + apiData[j].order + '.' + doc[m].order + '.&nbsp;' + doc[m].desc + '</a> </li>';
            }
            html += '</ul>';
            html += '</li>';
        }
    }
    return html;
}