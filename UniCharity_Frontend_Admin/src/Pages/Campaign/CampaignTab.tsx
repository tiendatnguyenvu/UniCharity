import { PageObject } from "../../Models/Paging";
import Table from "../../Components/Table/Table";
import Paging from "../../Components/Paging/Paging";
import "./CampaignTab.scss";


type Props = {
  tabs: any;
  handleClickTab: (tab: string) => void;
  pageObject: PageObject;
  data:any;
  configs:any;
  handlePageChange: (pageNumber: number) => void;
};
const CampaignTab = ({ tabs ,handleClickTab,pageObject,data,configs,handlePageChange}: Props) => {
  const renderTabs = {}

console.log("tab",tabs)
console.log("pageObject",pageObject)
console.log("data",data)
console.log("configs",configs)
  const renderTab = () => {
    const render =tabs.foreach((item,index:number) => {
      let render = "";
      render += `
        <input
          type="radio"
          name="pcss3t"
          id="tab${index + 1}"
          className="tab-content-first"
          ${status === item.status ? "checked" : ""}
        />
        <label
          htmlFor="tab${index + 1}"
          onClick={() => {
            handleClickTab(${item.status});
          }}
        >
          <i className="icon-bolt"></i>
          <h6>${item.status}</h6>
        </label>
      `;
    });
    return render;
  };

  const renderContenTabs = ()=>{
    const render =tabs.map((item,index:number)=>{
        return  <li key={index} className={`tab-content tab-content-${index ==0 ? "first": (index == tabs.length-1)?"last": index+1} typography`}>
        {data && (
          <div>
            {" "}
            <Paging
              currentPage={pageObject?.currentPage!}
              onPageChange={handlePageChange}
              pageSize={pageObject?.pageSize!}
              totalItems={pageObject?.totalItems!}
              totalPages={pageObject?.totalPages!}
            />
            <Table data={data} configs={configs} />
          </div>
        )}
      </li>
    })

    render.join(" ");
        console.log(render)
    return render;
  }
  return (
    <div className="my-tab">
      <div className="pcss3t pcss3t-effect-scale pcss3t-theme-1">
        {renderTab()}
        <ul>
    {/* {renderContenTabs()}   */}
        </ul>
    {/* <h1>h1</h1> */}
      </div>
    </div>
  );
};

export default CampaignTab;
