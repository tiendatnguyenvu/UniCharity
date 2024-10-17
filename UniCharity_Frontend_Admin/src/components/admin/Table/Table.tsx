type Props = {
  configs: any;
  data: any;
};

const Table = ({ configs, data }: Props) => {
  const renderedRows = data.map((item: any, index: number) => {
    // console.log("item",item)
    return (
      <tr className="" key={index}>
        {configs.map((config: any,i:number) => {
          return <td key={i}>{config.render(item, index)}</td>;
        })}
      </tr>
    );
  });

  const renderedHeaders = configs.map((config: any,i:number) => {
    return (
      <th
        className="p-4 text-xs font-medium text-gray-500 uppercase tracking-wider align-items-center"
        key={i}
      >
        {config.label}
      </th>
    );
  });

  return (
    <table className="table">
      <thead>
        <tr className="">{renderedHeaders}</tr>
      </thead>
      <tbody>
        {renderedRows} {/* Gọi hàm renderRows */}
      </tbody>
    </table>
  );
};

export default Table;
