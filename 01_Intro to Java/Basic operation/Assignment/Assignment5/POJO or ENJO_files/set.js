// -------------------------------------------------------------------
// markItUp!
// -------------------------------------------------------------------
// sphpblog
// -------------------------------------------------------------------

mySettings = {
	previewParserPath:	'~/../../../../parser.php', // path to your Wiki parser
	onShiftEnter:		{keepDefault:false, replaceWith:'\n\n'},
	markupSet: [
		{name:'Heading 1', key:'1', openWith:'[h1]', closeWith:'[/h1]', placeHolder:'Your title here...' },
		{name:'Heading 2', key:'2', openWith:'[h2]', closeWith:'[/h2]', placeHolder:'Your title here...' },
		{name:'Heading 3', key:'3', openWith:'[h3]', closeWith:'[/h3]', placeHolder:'Your title here...' },
		{name:'Heading 4', key:'4', openWith:'[h4]', closeWith:'[/h4]', placeHolder:'Your title here...' },
		{name:'Heading 5', key:'5', openWith:'[h5]', closeWith:'[/h5]', placeHolder:'Your title here...' },
		{name:'Heading 6', key:'6', openWith:'[h6]', closeWith:'[/h6]', placeHolder:'Your title here...' },
		{separator:'---------------' },		
		{name:'Center', key:'E', openWith:"[center]", closeWith:"[/center]"}, 
		{separator:'---------------' },		
		{name:'Bold', key:'B', openWith:"[strong]", closeWith:"[/strong]"}, 
		{name:'Italic', key:'I', openWith:"[em]", closeWith:"[/em]"}, 
		{name:'Underline', key:'U', openWith:"[u]", closeWith:"[/u]"}, 
		{name:'Strike through', key:'S', openWith:'[strike]', closeWith:'[/strike]'}, 
		{separator:'---------------' },
//		{name:'Picture', key:"R", replaceWith:'[img=[![Source URL:!:http://]!] popup=[![Popup full size?:!:false]!] float=[![Float (left/right):!:left]!] alt=[![Alt text]!]]'}, 
		{name:'Picture', key:"R", replaceWith:'[img=[![Source URL:!:http://]!] popup=[![Popup full size?:!:false]!] float=[![Float (left/right):!:left]!]]'}, 
		{name:'Url', key:"L", openWith:"[url=[![URL:!:http://]!]]", closeWith:'[/url]', placeHolder:'Your text to link here...' },
		{separator:'---------------' },
		{name:'Blockquote', key:"Q", openWith:'[blockquote]', closeWith:'[/blockquote]', placeHolder:''},
		{name:'Preformatted Text', key:"T", openWith:'[pre]', closeWith:'[/pre]'}, 
		{separator:'---------------' },
		{name:'Read More', key:"M", replaceWith:'[more]'}, 
		{separator:'---------------' },
		{name:'Preview', key:"P", call:'preview', className:'preview'}
	]
}
