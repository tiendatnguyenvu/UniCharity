/* eslint-disable @typescript-eslint/no-explicit-any */
/* eslint-disable @typescript-eslint/no-unused-vars */
type Props = {
  configs: any;
  data: any;
  onClickRecord?: (number: number) => void | undefined;
};

const Table = ({ configs, data, onClickRecord }: Props) => {
  // console.log("dataX",data)
  const renderedRows = data.map((item: any, index: number) => {
    return (
      <tr
        style={{ cursor: "pointer" }}
        className="shadow-sm"
        key={index}
        // onClick={() => { onClickRecord && onClickRecord(id)}}
      >
        {configs.map((config: any, i: number) => {
          return <td key={i}>{config.render(item, index)}</td>;
        })}
      </tr>
    );
  });

  const renderedHeaders = configs.map((config: any, index: number) => {
    return (
      <th
        className=" p-4 text-xs font-medium text-gray-500 uppercase tracking-wider  align-items-center"
        key={index}
      >
        {config.label}
      </th>
    );
  });

  

  return (
    <div className="col-12">
      <div className="shadow bg-light rounded h-100 p-4">
        <div className="table-responsive">
          <table className="table">
            <thead>
              <tr className="">{renderedHeaders}</tr>
            </thead>
            <tbody>{data && renderedRows}</tbody>
          </table>
        </div>
      </div>
    </div>
  );
};

export default Table;
