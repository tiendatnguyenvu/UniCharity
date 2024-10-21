import { useEffect, useState } from "react";
import { set } from "react-hook-form";
import ReactPaginate from "react-paginate";
import { array, number } from "yup";

type Props = {
  configs: any;
  data: any;
};

const Table = ({ configs, data }: Props) => {
  //
  const [index, setIndex] = useState(0);
  const [length, setLength] = useState(0);
  const [array, setArray] = useState<any>(data);
  const [totalPage, setTotalPage] = useState(0);
  const [pageSize, setPageSize] = useState(0);
  // console.log("dataTable", data);

  useEffect(() => {
    setIndex(1);
    setLength(data.length);
    setArray(data.slice(0, pageSize));
    setPageSize(5);
    setTotalPage(Math.ceil(data.length / 5));
  }, []);

  useEffect(() => {
    const x = (index - 1) * pageSize;
    setArray(data.slice(x, x + pageSize));
  }, [index]);

  // console.log(array);
  const renderedRows = array.map((item: any, index: number) => {
    // console.log("item",item)
    return (
      <tr className="" key={index}>
        {configs.map((config: any, i: number) => {
          return <td key={i}>{config.render(item, index)}</td>;
        })}
      </tr>
    );
  });

  const renderedHeaders = configs.map((config: any, i: number) => {
    return (
      <th
        className="p-4 text-xs font-medium text-gray-500 uppercase tracking-wider align-items-center"
        key={i}
      >
        {config.label}
      </th>
    );
  });

  const handlePageClick = (e: any) => {
    setIndex(e.selected + 1);
    // console.log("index", index);
    // console.log("length", length);
    // console.log("array", array);
    // console.log("totalPage", totalPage);
    // console.log("pageSize", pageSize);
  };

  // console.log(array);

  return (
    <>
      <table className="table">
        <thead>
          <tr className="">{renderedHeaders}</tr>
        </thead>
        <tbody>
          {renderedRows} {/* Gọi hàm renderRows */}
        </tbody>
      </table>

      <ReactPaginate
        breakLabel={<span>...</span>}
        nextLabel="next >"
        onPageChange={handlePageClick}
        pageRangeDisplayed={2}
        pageCount={totalPage}
        previousLabel="< previous"
        renderOnZeroPageCount={null}
        containerClassName={"pagination"}
        pageClassName={"page-item"}
        pageLinkClassName={"page-link"}
        previousClassName={"page-item"}
        previousLinkClassName={"page-link"}
        nextClassName={"page-item"}
        nextLinkClassName={"page-link"}
        breakClassName={"page-item"}
        breakLinkClassName={"page-link"}
        activeClassName={"active"}
      />
    </>
  );
};

export default Table;
